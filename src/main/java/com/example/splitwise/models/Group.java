package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Group {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String photo;

    private String bulletin;

    @ManyToMany
    private Set<User> users;
}
