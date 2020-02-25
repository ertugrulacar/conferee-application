package org.conferenceapplication.conferenceapplication.repository;

import org.conferenceapplication.conferenceapplication.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
