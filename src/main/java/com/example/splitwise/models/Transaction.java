package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    private String date;

    private String item;

    private Double amount;

    private String note;

    private String photo;

    @OneToMany
    private Set<TransactionDetail> details;
}
