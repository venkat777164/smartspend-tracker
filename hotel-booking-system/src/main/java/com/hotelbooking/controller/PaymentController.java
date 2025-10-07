package com.hotelbooking.controller;

import com.hotelbooking.dto.PaymentRequest;
import com.hotelbooking.model.Payment;
import com.hotelbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  @Autowired private BookingService bookingService;

  @PostMapping("/pay")
  public Payment pay(@RequestBody PaymentRequest req) {
    return bookingService.pay(req.getBookingId(), req.getAmount());
  }
}
