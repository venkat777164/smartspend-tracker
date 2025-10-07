package com.example.hotelbooking.repository;

import com.example.hotelbooking.model.Hotel;
import org.springframework.stereotype.Repository;

@Repository
public class HotelRepository extends BaseRepository<Hotel> {
    public Hotel save(Hotel hotel) {
        return super.save(hotel.getId(), hotel);
    }
}
