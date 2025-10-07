package com.example.hotelbooking.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Booking {
    private String id;
    private String userId;
    private String hotelId;
    private String roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String status; // CONFIRMED, CANCELLED
}
