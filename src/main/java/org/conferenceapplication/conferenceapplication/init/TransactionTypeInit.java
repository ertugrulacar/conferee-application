package org.conferenceapplication.conferenceapplication.init;

import org.conferenceapplication.conferenceapplication.model.TransactionType;
import org.conferenceapplication.conferenceapplication.repository.TransactionTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class TransactionTypeInit implements CommandLineRunner {
    private TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeInit(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if(transactionTypeRepository.count() == 0){
            transactionTypeRepository.saveAll(
                    Arrays.asList(
                            new TransactionType().setName("Giriş"),
                            new TransactionType().setName("Çıkış")

                    )
            );
        }
    }
}
