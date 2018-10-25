package com.universita.corsica.nomadaccomodationfinder.controller;

import com.universita.corsica.nomadaccomodationfinder.model.User;
import com.universita.corsica.nomadaccomodationfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> getAllUsers(){
        StringBuilder responseBody = new StringBuilder();
        for(User u : userService.findAll()){
            responseBody.append(u.toString());
            responseBody.append("</br></br>");
        }
        return ResponseEntity.ok(responseBody.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") String id){
        StringBuilder responseBody = new StringBuilder();
        User u = userService.findById(id);
        responseBody.append(u.toString());
        return ResponseEntity.ok(responseBody.toString());
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("User " + user.toString() + " inserted");
    }

}
