package com.universita.corsica.nomadaccomodationfinder.service;


import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

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
        return PropertyRepository.getInstance().findByDescription("desc1");
    }

}
