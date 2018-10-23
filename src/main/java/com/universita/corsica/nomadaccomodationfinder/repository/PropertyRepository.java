package com.universita.corsica.nomadaccomodationfinder.repository;


import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PropertyRepository implements CRUD<String, Property> {

    public static final PropertyRepository Instance = new PropertyRepository();

    public static PropertyRepository getInstance(){
        return Instance;
    }

    private Map<String, Property> database = new HashMap<String, Property>();

    public List<Property> getAll() {
        return new ArrayList<Property>(database.values());
    }

    public Property getById(String id) {
        return database.get(id);
    }

    public Property saveOrUpdate(Property entity) {
        return database.put(entity.getId(), entity);
    }

    @Override
    public Property deleteById(String entity) {
        return database.remove(entity);
    }

    public Property deleteById(Property entity) {
        return database.remove(entity);
    }

    public Property findByDescription(String description){
        for(Property p : database.values()){
            if(p.description.equals(description)){
                return p;
            }
        }
        return null;
    }

    public List<Property> findInRadius(double latitude, double longitude, double radiusKm){
        return null;
    }

    public List<Property> findByKeywords(Collection<String> keywords){
        return null;
    }

    public List<Property> findByScoreAbove(int note){
        return null;
    }

}
