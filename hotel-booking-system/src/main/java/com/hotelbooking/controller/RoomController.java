package com.hotelbooking.controller;

import com.hotelbooking.model.Room;
import com.hotelbooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

  @Autowired private RoomRepository roomRepo;

  @GetMapping("/hotel/{hotelId}")
  public List<Room> byHotel(@PathVariable String hotelId) {
    return roomRepo.findByHotelId(hotelId);
  }

  @PostMapping
  public Room create(@RequestBody Room r) { return roomRepo.save(r); }

  @PutMapping("/{id}")
  public Room update(@PathVariable String id, @RequestBody Room in) {
    Room r = roomRepo.findById(id).orElseThrow();
    r.setRoomType(in.getRoomType());
    r.setTotalRooms(in.getTotalRooms());
    r.setPricePerNight(in.getPricePerNight());
    return roomRepo.save(r);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable String id) { roomRepo.deleteById(id); return "Deleted"; }
}
