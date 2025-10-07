package com.example.hotelbooking.repository;

import com.example.hotelbooking.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository extends BaseRepository<User> {
    public Optional<User> findByUsername(String username) {
        return findAll().stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst();
    }
}
