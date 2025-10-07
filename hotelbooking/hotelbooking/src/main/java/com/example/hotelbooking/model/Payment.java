package com.example.hotelbooking.model;

import lombok.Data;

@Data
public class Payment {
    private String id;
    private String bookingId;
    private double amount;
    private String status; // SUCCESS, FAILED
}