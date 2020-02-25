package org.conferenceapplication.conferenceapplication.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.conferenceapplication.conferenceapplication.config.HibernateProxyTypeAdapter;
import org.conferenceapplication.conferenceapplication.model.Transaction;
import org.conferenceapplication.conferenceapplication.model.User;
import org.conferenceapplication.conferenceapplication.repository.TransactionRepository;
import org.conferenceapplication.conferenceapplication.repository.TransactionTypeRepository;
import org.conferenceapplication.conferenceapplication.repository.UserRepository;
import org.conferenceapplication.conferenceapplication.source.TrsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    private Gson gson = new GsonBuilder().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();

    private final String defaultAuthorization = "fdf4fb318fe8ee67bede8153dded398ec82ee3504fa5d1ce428325086215dafc";

    @PutMapping(value = "enter", produces = "application/json")
    public ResponseEntity<String> enter(@RequestHeader("Authorization") final String authorization, @PathParam("qrToken") final String qrToken) {
        if (!defaultAuthorization.equals(defaultAuthorization))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        Optional<User> user = userRepository.findUserByQrToken(qrToken);
        if (!user.isPresent())
            return new ResponseEntity<>("Bu QR tokenına sahip kullanıcı bulunamadı", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(gson.toJson(transactionRepository.saveAndFlush(new Transaction().setUser(user.get()).setTime(new Timestamp(System.currentTimeMillis())).setTransactionType(transactionTypeRepository.getOne(TrsType.ENTER)))), HttpStatus.CREATED);
    }

    @PutMapping(value = "leave", produces = "application/json")
    public ResponseEntity<String> leave(@RequestHeader("Authorization") final String authorization, @PathParam("qrToken") final String qrToken) {
        if (!defaultAuthorization.equals(defaultAuthorization))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        Optional<User> user = userRepository.findUserByQrToken(qrToken);
        if (!user.isPresent())
            return new ResponseEntity<>("Bu QR tokenına sahip kullanıcı bulunamadı", HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(gson.toJson(transactionRepository.saveAndFlush(new Transaction().setUser(user.get()).setTime(new Timestamp(System.currentTimeMillis())).setTransactionType(transactionTypeRepository.getOne(TrsType.LEAVE)))), HttpStatus.CREATED);
    }
}