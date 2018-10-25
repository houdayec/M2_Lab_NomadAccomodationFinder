package com.universita.corsica.nomadaccomodationfinder.repository;

import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserRepository extends ElasticsearchCrudRepository<User, String> {

    List<User> findByLastName(String lastName);

    List<User> findByFirstName(String firstName);

    List<User> findByEmail(String email);

    User deleteUserById(String id);


    /*private Map<String, User> database = new HashMap<String, User>();

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(database.values());
    }

    @Override
    public User findById(String id) {
        return database.get(id);
    }

    @Override
    public User saveOrUpdate(User entity) {
        return database.put(entity.getId(), entity);
    }

    @Override
    public User deleteById(String entity) {
        return database.remove(entity);
    }

    public boolean saveOrUpdateList(List<User> entities) {
        for(User u : entities){
            database.put(u.getId(), u);
        }
        return true;
    }

    public User findByEmail(String email){
        for(User u : database.values()){
            if(u.getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    public User findByFirstname(String firstname){
        for(User u : database.values()){
            if(u.getFirstName().equals(firstname)){
                return u;
            }
        }
        return null;
    }*/

}
