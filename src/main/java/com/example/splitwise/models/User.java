package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String photo;

    @ManyToMany
    private Set<Group> groups;
}
