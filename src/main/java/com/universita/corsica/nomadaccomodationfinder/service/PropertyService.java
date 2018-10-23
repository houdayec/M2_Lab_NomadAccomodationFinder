package com.universita.corsica.nomadaccomodationfinder.service;


import com.universita.corsica.nomadaccomodationfinder.enums.TypeProperty;
import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @PostConstruct
    public void fakeDBpopulate(){
        List<Property> listProperties = new ArrayList<>();
        Property p = new Property().withId("1").withType(TypeProperty.APPARTMENT).withPrice(12);
        Property p2 = new Property().withId("2").withType(TypeProperty.VILLA).withPrice(132);
        Property p3 = new Property().withId("3").withType(TypeProperty.HOUSE).withPrice(32);
        Property p4 = new Property().withId("4").withType(TypeProperty.VILLA).withPrice(142);
        Property p5 = new Property().withId("5").withType(TypeProperty.APPARTMENT).withPrice(32);

        listProperties.add(p);
        listProperties.add(p2);
        listProperties.add(p3);
        listProperties.add(p4);
        listProperties.add(p5);

        /**
         * KEYWORD RANDOM GENERATION
         */
        for (Property prop : listProperties){
            List<String> listKeywords = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                int r = (int) (Math.random()*7);
                listKeywords.add(new String [] {"New","Big","Warm","Cold","Little","Old", "Far", "Close"}[r]);
            }
            prop.setKeywords(listKeywords);
        }

        propertyRepository.saveOrUpdateList(listProperties);
    }

    /**
     *
     * findByDescription(String description);
     * Haversine formula -> get distance with coordinates
     * findInRadius(double latitude, double longitude, double radiusKm);
     * findByTags(Collections<String>tags);
     * fincByScoreAbove(double score);
     *
     *
     */

    public Property findByDescription(String description){
        return propertyRepository.findByDescription(description);
    }

    public List<Property> findByKeywords(Collection<String> keywords){
        return propertyRepository.findByKeywords(keywords);
    }

    public List<Property> findByScoreAbove(int note){
        return propertyRepository.findByScoreAbove(note);
    }

    public List<Property> findByType(TypeProperty typeProperty){
        return propertyRepository.findByType(typeProperty);
    }

}
