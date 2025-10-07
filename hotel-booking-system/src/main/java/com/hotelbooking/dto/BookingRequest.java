package com.hotelbooking.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequest {
  private String userId;
  private String hotelId;
  private String roomId;
  private LocalDate checkIn;
  private LocalDate checkOut;
}
