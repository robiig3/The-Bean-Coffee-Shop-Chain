package com.coffeeshop.controller;

import com.coffeeshop.model.Shop;
import com.coffeeshop.model.User;
import com.coffeeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public Collection<User> getAllUsers(){ return userService.getAllUsers();}

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("/find/{username}")
    public User findUserByUsername(@PathVariable String username){
        return userService.findUserByUsername(username);}

    @PostMapping("/login")
    public long login(@RequestBody User user){
        System.out.println(user.toString());
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user){

        System.out.println(user.toString());
        userService.addUser(user);
        return "User added";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        System.out.println(user.toString());
        System.out.println("ID: " + id);
        userService.updateUser(id, user.getName(), user.getSurname());
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){ userService.deleteUser(id);}

}
