package com.hotelbooking.dto;

import lombok.Data;

@Data
public class PaymentRequest {
  private String bookingId;
  private Double amount;
  private String paymentMethod; // optional
}
