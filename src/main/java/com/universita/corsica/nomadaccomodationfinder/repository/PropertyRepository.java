package com.universita.corsica.nomadaccomodationfinder.repository;


import com.universita.corsica.nomadaccomodationfinder.enums.TypeProperty;
import com.universita.corsica.nomadaccomodationfinder.model.Comment;
import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PropertyRepository implements CRUD<String, Property> {

    private static Map<String, Property> database = new HashMap<String, Property>();

    @Override
    public List<Property> findAll() {
        return new ArrayList<Property>(database.values());
    }

    @Override
    public Property findById(String id) {
        return database.get(id);
    }

    @Override
    public Property saveOrUpdate(Property entity) {
        return database.put(entity.getId(), entity);
    }

    public boolean saveOrUpdateList(List<Property> entities) {
        for(Property p : entities){
            database.put(p.getId(), p);
        }
        return true;
    }

    @Override
    public Property deleteById(String entity) {
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
        List<Property> listProperties = new ArrayList<>();

        for(Property p : database.values()){
            for (String keyword : keywords){
                if(p.keywords.contains(keyword)){
                    listProperties.add(p);
                }
            }
        }

        return listProperties;
    }

    public List<Property> findByScoreAbove(int note){
        List<Property> listProperties = new ArrayList<>();

        for(Property p : database.values()){
            double average = p.getComments().stream().mapToDouble(Comment::getNote).average().getAsDouble();
            if(average >= note){
                listProperties.add(p);
            }
        }

        return listProperties;
    }

    public List<Property> findByType(TypeProperty type){
        List<Property> listProperties = new ArrayList<>();

        for(Property p : database.values()){
            if(p.getType() == type)
                listProperties.add(p);
        }

        return listProperties;
    }

}
