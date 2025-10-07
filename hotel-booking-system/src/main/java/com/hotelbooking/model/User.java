package com.hotelbooking.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @NoArgsConstructor @AllArgsConstructor
@Document(collection = "users")
public class User {
  @Id
  private String id;

  @Indexed(unique = true)
  private String username;

  @Indexed(unique = true)
  private String email;

  private String password; // bcrypt

  // "USER" or "ADMIN"
  private String role = Role.USER;
}