package org.conferenceapplication.conferenceapplication.model;


import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String qrToken;

    private String name;

    private String lastname;

    public User() {}

    public Long getId() {
        return id;
    }

    public String getQrToken() {
        return qrToken;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public User setQrToken(String qrToken) {
        this.qrToken = qrToken;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
}
