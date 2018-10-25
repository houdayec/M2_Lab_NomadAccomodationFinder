package com.universita.corsica.nomadaccomodationfinder.controller;

import com.universita.corsica.nomadaccomodationfinder.model.User;
import com.universita.corsica.nomadaccomodationfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
