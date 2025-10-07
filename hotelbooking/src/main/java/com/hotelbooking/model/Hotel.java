package com.hotelbooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String city;
    private String address;
    private String description;
    private Double rating;
    private List<Room> rooms; // embedded rooms for simplicity

    // constructors, getters, setters
    public Hotel() {}
    public Hotel(String name, String city, String address, String description, Double rating, List<Room> rooms) {
        this.name = name; this.city = city; this.address = address;
        this.description = description; this.rating = rating; this.rooms = rooms;
    }
    // getters & setters ...
}
