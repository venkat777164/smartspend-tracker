package com.example.hotelbooking.model;

import lombok.Data;

@Data
public class Room {
    private String id;
    private String type;  // Single, Double, Suite
    private double price;
    private boolean available;
}