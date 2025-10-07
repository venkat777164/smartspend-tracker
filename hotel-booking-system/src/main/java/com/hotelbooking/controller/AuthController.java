package com.hotelbooking.controller;

import com.hotelbooking.dto.*;
import com.hotelbooking.model.Role;
import com.hotelbooking.model.User;
import com.hotelbooking.repository.UserRepository;
import com.hotelbooking.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired private UserRepository userRepo;
  @Autowired private PasswordEncoder encoder;
  @Autowired private AuthenticationManager authManager;
  @Autowired private JwtService jwtService;

  @PostMapping("/register")
  public String register(@RequestBody RegisterRequest r) {
    if (userRepo.existsByUsername(r.getUsername())) return "Username taken";
    if (userRepo.existsByEmail(r.getEmail())) return "Email taken";

    User u = new User();
    u.setUsername(r.getUsername());
    u.setEmail(r.getEmail());
    u.setPassword(encoder.encode(r.getPassword()));
    if ("ADMIN".equalsIgnoreCase(r.getRole())) u.setRole(Role.ADMIN);
    userRepo.save(u);
    return "Registered";
  }

  @PostMapping("/login")
  public AuthResponse login(@RequestBody AuthRequest req) {
    authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
    String token = jwtService.generateToken(req.getUsername());
    return new AuthResponse(token);
  }
}
