package com.universita.corsica.nomadaccomodationfinder.repository;

import com.universita.corsica.nomadaccomodationfinder.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository implements CRUD<String, User> {

    private Map<String, User> database = new HashMap<String, User>();

    public List<User> getAll() {
        return new ArrayList<User>(database.values());
    }

    public User getById(String id) {
        return database.get(id);
    }

    public User saveOrUpdate(User entity) {
        return database.put(entity.getId(), entity);
    }

    public User deleteById(String entity) {
        return database.remove(entity);
    }
}
