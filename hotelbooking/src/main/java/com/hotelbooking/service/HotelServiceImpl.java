package com.hotelbooking.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository repo;
    public HotelServiceImpl(HotelRepository repo) { this.repo = repo; }

    @Override public List<Hotel> findAll() { return repo.findAll(); }
    @Override public Optional<Hotel> findById(String id) { return repo.findById(id); }
    @Override public List<Hotel> findByCity(String city) { return repo.findByCityIgnoreCase(city); }
    @Override public Hotel save(Hotel hotel) { return repo.save(hotel); }
}
