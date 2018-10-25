package com.universita.corsica.nomadaccomodationfinder.controller;

import com.universita.corsica.nomadaccomodationfinder.model.Comment;
import com.universita.corsica.nomadaccomodationfinder.model.Property;
import com.universita.corsica.nomadaccomodationfinder.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller()
@RequestMapping("/accomodations")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public ResponseEntity<String> getAllAccomodations(){
        StringBuilder sb = new StringBuilder();
        for (Property p : propertyService.findAll()){
            sb.append(p.toString());
            sb.append("</br></br>");
        }
        return ResponseEntity.ok(sb.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getAccomodationById(@PathVariable("id") String searchedId){
        System.out.println(searchedId);
        StringBuilder responseBody = new StringBuilder();
        responseBody.append(propertyService.findById(searchedId));
        return ResponseEntity.ok(responseBody.toString());
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<String> getAccomodationsComments(@PathVariable("id") String searchedId){
        StringBuilder responseBody = new StringBuilder();
        for(Comment c : propertyService.findById(searchedId).comments){
            responseBody.append(c);
            responseBody.append("</br></br>");
        }
        return ResponseEntity.ok(responseBody.toString());
    }

    @PostMapping()
    @Validated
    public ResponseEntity<String> addAccomodation(@RequestBody Property property){
        propertyService.insertProperty(property);
        return ResponseEntity.ok("Accomodation " + property + " inserted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccomodationById(@PathVariable("id") String searchedId) {
        propertyService.deleteById(searchedId);
        return ResponseEntity.ok("Accomodation " + searchedId + " deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateAccomodation(@RequestBody @Valid Property property){
        propertyService.updateProperty(property);
        return ResponseEntity.ok("Accomodation " + property.toString() + " updated in database");
    }

}
