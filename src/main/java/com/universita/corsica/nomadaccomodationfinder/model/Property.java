package com.universita.corsica.nomadaccomodationfinder.model;

import com.universita.corsica.nomadaccomodationfinder.enums.Amenity;
import com.universita.corsica.nomadaccomodationfinder.enums.TypeProperty;

import java.net.URL;
import java.util.List;

public class Property {

    /**
     * INTERN STATE
     */
    public String id;
    public TypeProperty type;
    public float surface;
    public int maxOccupancy;
    public int numberRooms;
    public String description;
    public List<URL> listURLPhotos;
    public User owner;
    public float price;
    public List<String> keywords;
    public List<Amenity> amenities;
    public List<Comment> comments;

    /**
     * GETTERS AND SETTERS
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TypeProperty getType() {
        return type;
    }

    public void setType(TypeProperty type) {
        this.type = type;
    }

    public float getSurface() {
        return surface;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public int getNumberRooms() {
        return numberRooms;
    }

    public void setNumberRooms(int numberRooms) {
        this.numberRooms = numberRooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<URL> getListURLPhotos() {
        return listURLPhotos;
    }

    public void setListURLPhotos(List<URL> listURLPhotos) {
        this.listURLPhotos = listURLPhotos;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Property() {
    }

    /**
     * DEFAULT CONSTRUCTOR
     */


    public Property withPrice(float price) {
        this.setPrice(price);
        return this;
    }

    public Property withId(String id){
        this.setId(id);
        return this;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", surface=" + surface +
                ", maxOccupancy=" + maxOccupancy +
                ", numberRooms=" + numberRooms +
                ", description='" + description + '\'' +
                ", listURLPhotos=" + listURLPhotos +
                ", owner=" + owner +
                ", price=" + price +
                ", keywords=" + keywords +
                ", amenities=" + amenities +
                ", comments=" + comments +
                '}';
    }

    /**
     * OVERRIDED METHODS
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property = (Property) o;

        if (Float.compare(property.surface, surface) != 0) return false;
        if (maxOccupancy != property.maxOccupancy) return false;
        if (numberRooms != property.numberRooms) return false;
        if (Float.compare(property.price, price) != 0) return false;
        if (id != null ? !id.equals(property.id) : property.id != null) return false;
        if (type != property.type) return false;
        if (description != null ? !description.equals(property.description) : property.description != null)
            return false;
        if (listURLPhotos != null ? !listURLPhotos.equals(property.listURLPhotos) : property.listURLPhotos != null)
            return false;
        if (owner != null ? !owner.equals(property.owner) : property.owner != null) return false;
        if (keywords != null ? !keywords.equals(property.keywords) : property.keywords != null) return false;
        return amenities != null ? amenities.equals(property.amenities) : property.amenities == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (surface != +0.0f ? Float.floatToIntBits(surface) : 0);
        result = 31 * result + maxOccupancy;
        result = 31 * result + numberRooms;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (listURLPhotos != null ? listURLPhotos.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (amenities != null ? amenities.hashCode() : 0);
        return result;
    }
}
