package com.example.splitwise.repositories;

import com.example.splitwise.models.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {

}
