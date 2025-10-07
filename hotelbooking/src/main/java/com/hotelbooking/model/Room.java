package com.hotelbooking.model;

public class Room {
    private String id;
    private String number;
    private String type; // e.g., "SINGLE", "DOUBLE"
    private double price;
    private boolean available = true;

    // constructors, getters, setters
    public Room() {}
    public Room(String id, String number, String type, double price) {
        this.id = id; this.number = number; this.type = type; this.price = price;
    }
    // getters & setters ...
}
