package com.universita.corsica.nomadaccomodationfinder.controller;

import com.universita.corsica.nomadaccomodationfinder.model.User;
import com.universita.corsica.nomadaccomodationfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    @Validated
    public ResponseEntity<User> addUser(@RequestBody @Valid User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.removeUser(id));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody @Valid User user){
        return ResponseEntity.ok(userService.updateUser(user));
    }

}
