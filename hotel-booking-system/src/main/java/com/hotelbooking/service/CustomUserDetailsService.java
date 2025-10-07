package com.hotelbooking.service;

import com.hotelbooking.model.User;
import com.hotelbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UserRepository userRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User u = userRepo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return org.springframework.security.core.userdetails.User.builder()
        .username(u.getUsername())
        .password(u.getPassword())
        .roles(u.getRole()) // "ADMIN" or "USER"
        .build();
  }
}
