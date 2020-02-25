package org.conferenceapplication.conferenceapplication.repository;

import org.conferenceapplication.conferenceapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User AS user WHERE user.qrToken= ?1")
    Optional<User> findUserByQrToken(String qrToken);
}
