package com.example.splitwise.services.Impl;

import com.example.splitwise.models.User;
import com.example.splitwise.repositories.UserRepository;
import com.example.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setPhoto(user.getPhoto());

        userRepository.save(existingUser);
    }
}
