package com.hotelbooking.controller;

import com.hotelbooking.model.*;
import com.hotelbooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

  @Autowired private UserRepository userRepo;
  @Autowired private HotelRepository hotelRepo;
  @Autowired private RoomRepository roomRepo;
  @Autowired private BookingRepository bookingRepo;
  @Autowired private PaymentRepository paymentRepo;

  @GetMapping("/dashboard")
  public Map<String,Object> stats() {
    return Map.of(
      "totalUsers", userRepo.count(),
      "totalHotels", hotelRepo.count(),
      "totalRooms", roomRepo.count(),
      "totalBookings", bookingRepo.count(),
      "totalPayments", paymentRepo.count()
    );
  }
}
