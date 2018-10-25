package com.universita.corsica.nomadaccomodationfinder.service;

import com.universita.corsica.nomadaccomodationfinder.model.User;
import com.universita.corsica.nomadaccomodationfinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void fakeDBPopulate(){
        String[] firstnames = new String [] {"Corentin","Cyril","Anthony","Mathieu","Melissa","Thomas", "Emilie"};
        String[] emails = new String [] { "houdayer.corentin@gmail.com", "cyril.niobe@gmail.com", "anthony.seve@gmail.com", "mathieu.puertas@gmail.com", "melissa.llorens@gmail.com", "thomas.milioni@gmail.com", "emilie.aslan@gmail.com"};
        for(int i= 0; i < firstnames.length; i++){
            User u = new User().withId(String.valueOf(i+1)).withFirstname(firstnames[i]).withEmail(emails[i]);
            userRepository.save(u);
        }
    }

    public List<User> findAll(){
        List<User> foundUsers = new ArrayList<>();
        userRepository.findAll().forEach(foundUsers::add);
        return foundUsers;
    }

    public User findById(String id){
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    public List<User> findByLastName(String firstname){
        return userRepository.findByFirstName(firstname);
    }

    public List<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User removeUser(String id){
        return userRepository.deleteUserBy(id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public List<User> findByRadius(GeoPoint origin, String radius){
        CriteriaQuery query = new CriteriaQuery(
                new Criteria("location")
                .within(origin, radius)
        );
        return elasticsearchTemplate.queryForList(query, User.class);
    }

}
