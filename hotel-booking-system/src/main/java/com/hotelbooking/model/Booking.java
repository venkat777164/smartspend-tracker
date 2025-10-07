package com.hotelbooking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "bookings")
public class Booking {
  @Id
  private String id;

  private String userId;
  private String hotelId;
  private String roomId;

  private LocalDate checkIn;
  private LocalDate checkOut;

  // PENDING, CONFIRMED, CANCELLED
  private String status;

  private Double amount;
}
