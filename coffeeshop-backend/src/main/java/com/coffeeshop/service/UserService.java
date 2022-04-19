package com.coffeeshop.service;

import com.coffeeshop.model.Shop;
import com.coffeeshop.model.User;
import com.coffeeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public User findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) { userRepository.deleteUser(id);}

    public long login(String username, String password) {
        return userRepository.login(username, password);
    }

    public void updateUser(Long id, String name, String surname) {
        userRepository.updateUser(id, name, surname);
    }
}
