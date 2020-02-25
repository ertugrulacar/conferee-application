package org.conferenceapplication.conferenceapplication.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp time;

    @ManyToOne
    private User user;

    @ManyToOne
    private TransactionType transactionType;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
    }

    public User getUser() {
        return user;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public Transaction setTime(Timestamp time) {
        this.time = time;
        return this;
    }

    public Transaction setUser(User user) {
        this.user = user;
        return this;
    }

    public Transaction setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }
}
