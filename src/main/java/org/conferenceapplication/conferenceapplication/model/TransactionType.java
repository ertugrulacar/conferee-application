package org.conferenceapplication.conferenceapplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TransactionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public TransactionType() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TransactionType setId(Long id) {
        this.id = id;
        return this;
    }

    public TransactionType setName(String name) {
        this.name = name;
        return this;
    }
}
