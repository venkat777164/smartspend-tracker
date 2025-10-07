package com.hotelbooking.controller;

import com.hotelbooking.dto.BookingRequest;
import com.hotelbooking.model.Booking;
import com.hotelbooking.repository.BookingRepository;
import com.hotelbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  @Autowired private BookingService bookingService;
  @Autowired private BookingRepository bookingRepo;

  @PostMapping("/create")
  public Booking create(@RequestBody BookingRequest req) {
    return bookingService.createBooking(req);
  }

  @GetMapping("/user/{userId}")
  public List<Booking> byUser(@PathVariable String userId) {
    return bookingRepo.findByUserId(userId);
  }

  @PostMapping("/cancel/{id}")
  public String cancel(@PathVariable String id) {
    bookingService.cancel(id);
    return "Cancelled";
  }
}
