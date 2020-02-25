package org.conferenceapplication.conferenceapplication.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.conferenceapplication.conferenceapplication.config.HibernateProxyTypeAdapter;
import org.conferenceapplication.conferenceapplication.model.User;
import org.conferenceapplication.conferenceapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private Gson gson = new GsonBuilder().registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY).create();


    @GetMapping(value = "all", produces = "application/json")
    public ResponseEntity<String> findAll(){
        return new ResponseEntity<>(gson.toJson(userRepository.findAll()), HttpStatus.OK);
    }
    @PostMapping(value = "create", produces = "application/json")
    public ResponseEntity<String> create(@RequestBody final User user){
        return new ResponseEntity<>(gson.toJson(userRepository.saveAndFlush(user.setId(0L))), HttpStatus.CREATED);
    }


}
