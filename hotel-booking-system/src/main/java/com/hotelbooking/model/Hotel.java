package com.hotelbooking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "hotels")
public class Hotel {
  @Id
  private String id;
  private String name;
  private String city;
  private String address;
  private String description;
  private Double rating;
}
