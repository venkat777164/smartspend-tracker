package com.hotelbooking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "rooms")
public class Room {
  @Id
  private String id;
  private String hotelId;       // reference to Hotel
  private String roomType;      // Deluxe, Single, Suite
  private Integer totalRooms;   // inventory for this type
  private Double pricePerNight;
}
