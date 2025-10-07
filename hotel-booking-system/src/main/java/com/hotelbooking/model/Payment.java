package com.hotelbooking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "payments")
public class Payment {
  @Id
  private String id;

  private String bookingId;
  private Double amount;
  private String status;         // SUCCESS, FAILED
  private String paymentRef;     // UUID
  private LocalDateTime timestamp;
}
