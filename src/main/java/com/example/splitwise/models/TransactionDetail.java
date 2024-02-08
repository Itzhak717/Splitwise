package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class TransactionDetail {
    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;

    private String currency;

    @OneToOne
    private User user;

    @ManyToOne
    private Transaction transaction;
}
