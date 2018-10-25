package com.universita.corsica.nomadaccomodationfinder.service;

import com.universita.corsica.nomadaccomodationfinder.model.User;
import com.universita.corsica.nomadaccomodationfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void fakeDBPopulate(){
        String[] firstnames = new String [] {"Corentin","Cyril","Anthony","Mathieu","Melissa","Thomas", "Emilie"};
        String[] emails = new String [] { "houdayer.corentin@gmail.com", "cyril.niobe@gmail.com", "anthony.seve@gmail.com", "mathieu.puertas@gmail.com", "melissa.llorens@gmail.com", "thomas.milioni@gmail.com", "emilie.aslan@gmail.com"};
        for(int i= 0; i < firstnames.length; i++){
            User u = new User().withId(String.valueOf(i+1)).withFirstname(firstnames[i]).withEmail(emails[i]);
            userRepository.saveOrUpdate(u);
        }
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        return userRepository.findById(id);
    }

    public User findByFirstname(String firstname){
        return userRepository.findByFirstname(firstname);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean addUser(User user){
        userRepository.saveOrUpdate(user);
        return true;
    }

}
