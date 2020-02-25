package org.conferenceapplication.conferenceapplication.repository;

import org.conferenceapplication.conferenceapplication.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
