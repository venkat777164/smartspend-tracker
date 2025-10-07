package com.hotelbooking.service;

import com.hotelbooking.dto.BookingRequest;
import com.hotelbooking.model.Hotel;
import com.hotelbooking.model.Room;
import com.hotelbooking.repository.HotelRepository;
import com.hotelbooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {
  @Autowired private HotelRepository hotelRepo;
  @Autowired private RoomRepository roomRepo;
  @Autowired private BookingService bookingService;

  public List<Map<String,Object>> search(String city, String start, String end) {
    var startDate = java.time.LocalDate.parse(start);
    var endDate = java.time.LocalDate.parse(end);

    List<Hotel> hotels = hotelRepo.findByCityIgnoreCase(city);
    List<Map<String,Object>> result = new ArrayList<>();

    for (Hotel h : hotels) {
      List<Room> rooms = roomRepo.findByHotelId(h.getId());
      List<Map<String,Object>> available = new ArrayList<>();

      for (Room r : rooms) {
        BookingRequest req = new BookingRequest();
        req.setHotelId(h.getId());
        req.setRoomId(r.getId());
        req.setCheckIn(startDate);
        req.setCheckOut(endDate);
        int avail = bookingService.availableRooms(r.getId(), req);
        if (avail > 0) {
          Map<String,Object> m = new LinkedHashMap<>();
          m.put("roomId", r.getId());
          m.put("roomType", r.getRoomType());
          m.put("pricePerNight", r.getPricePerNight());
          m.put("availableRooms", avail);
          available.add(m);
        }
      }
      if (!available.isEmpty()) {
        Map<String,Object> hotelMap = new LinkedHashMap<>();
        hotelMap.put("hotel", h);
        hotelMap.put("rooms", available);
        result.add(hotelMap);
      }
    }
    return result;
  }
}
