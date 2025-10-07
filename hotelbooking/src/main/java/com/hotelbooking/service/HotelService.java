package com.hotelbooking.service;

import com.hotelbooking.model.Hotel;
import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(String id);
    List<Hotel> findByCity(String city);
    Hotel save(Hotel hotel);
}
