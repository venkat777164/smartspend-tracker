package com.example.hotelbooking.repository;

import com.example.hotelbooking.model.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class BookingRepository extends BaseRepository<Booking> {
    public Booking save(Booking booking) {
        return super.save(booking.getId(), booking);
    }
}