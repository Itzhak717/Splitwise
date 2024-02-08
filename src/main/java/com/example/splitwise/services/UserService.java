package com.example.splitwise.services;

import com.example.splitwise.models.User;

import java.util.Optional;

public interface UserService {

    public User getUserById(Long id);

    public void createUser(User user);

    public void updateUser(User user);

}
