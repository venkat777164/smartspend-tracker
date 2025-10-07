package com.example.hotelbooking.model;

import lombok.Data;
import java.util.List;

@Data
public class Hotel {
    private String id;
    private String name;
    private String city;
    private String address;
    private String description;
    private double rating;
    private List<Room> rooms;
}