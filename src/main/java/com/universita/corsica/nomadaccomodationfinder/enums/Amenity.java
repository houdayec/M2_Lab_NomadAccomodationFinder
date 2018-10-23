package com.universita.corsica.nomadaccomodationfinder.enums;

public enum Amenity {

    WIFI("Wi-Fi Connection"),
    DISHWASHER("Dishwasher"),
    TV("Television"),
    LIFT("Elevator"),
    IRON("Iron"),
    KITCHEN("Kitchen"),
    HAIRDRYER("Hair Dryer"),
    AIRCONDITIONNING("Air-Conditionning");

    private String name = "";

    /**
     * CONTRUCTOR
     */
    Amenity(String name){
        this.name = name;
    }

    /**
     * OVERRIDED METHODS
     */
    @Override
    public String toString() {
        return "Amenity{" +
                "name='" + name + '\'' +
                '}';
    }
}
