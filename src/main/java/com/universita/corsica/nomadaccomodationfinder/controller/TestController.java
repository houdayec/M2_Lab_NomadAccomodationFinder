package com.universita.corsica.nomadaccomodationfinder.controller;

import com.universita.corsica.nomadaccomodationfinder.enums.TypeProperty;
import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/type")
    public ResponseEntity<String> getType() {
        /**
         * FETCHING ACCOMODATIONS BY TYPE
         */
        TypeProperty searchedProperty = TypeProperty.APPARTMENT;

        List<Property> foundProperties = propertyService.findByType(searchedProperty);

        StringBuilder sb = new StringBuilder();

        if(foundProperties.size() > 0){

            sb.append("We found " + foundProperties.size() + " accomodations which are " + searchedProperty.name());
            sb.append("</br></br>");
            sb.append("List of matching accomodations :");
            sb.append("</br></br>");
            for (Property p : foundProperties){
                sb.append(p.toString());
                sb.append("</br>");
            }

        }
        return ResponseEntity.ok(sb.toString());
    }

    @GetMapping("/keywords")
    public ResponseEntity<String> getKeywords() {
        /**
         * FETCHING ACCOMODATIONS BY TYPE
         */
        List<String> searchedKeywords = new ArrayList<>();
        searchedKeywords.add("Big");
        //searchedKeywords.add("Close");

        List<Property> foundProperties = propertyService.findByKeywords(searchedKeywords);

        StringBuilder sb = new StringBuilder();

        if(foundProperties.size() > 0){

            sb.append("We found " + foundProperties.size() + " accomodations which are tagged with " + searchedKeywords.get(0));
            sb.append("</br></br>");
            sb.append("List of matching accomodations :");
            sb.append("</br></br>");
            for (Property p : foundProperties){
                sb.append(p.toString());
                sb.append("</br>");
            }

        }
        return ResponseEntity.ok(sb.toString());
    }
}
