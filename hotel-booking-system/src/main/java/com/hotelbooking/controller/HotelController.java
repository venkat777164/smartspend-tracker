package com.hotelbooking.controller;

import com.hotelbooking.model.Hotel;
import com.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

  @Autowired private HotelRepository hotelRepo;

  @GetMapping public List<Hotel> all() { return hotelRepo.findAll(); }

  @GetMapping("/{id}")
  public Hotel one(@PathVariable String id) { return hotelRepo.findById(id).orElseThrow(); }

  @PostMapping
  public Hotel create(@RequestBody Hotel h) { return hotelRepo.save(h); }

  @PutMapping("/{id}")
  public Hotel update(@PathVariable String id, @RequestBody Hotel in) {
    Hotel h = hotelRepo.findById(id).orElseThrow();
    h.setName(in.getName()); h.setCity(in.getCity()); h.setAddress(in.getAddress());
    h.setDescription(in.getDescription()); h.setRating(in.getRating());
    return hotelRepo.save(h);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) { hotelRepo.deleteById(id); return "Deleted"; }
}
