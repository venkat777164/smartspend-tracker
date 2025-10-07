package com.example.hotelbooking.controller.view;

import com.example.hotelbooking.model.Hotel;
import com.example.hotelbooking.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hotels")
public class HotelViewController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public String listHotels(Model model) {
        List<Hotel> hotels = hotelRepository.findAll();
        model.addAttribute("hotels", hotels);
        return "hotels";  // templates/hotels.html
    }

    @GetMapping("/new")
    public String newHotelForm() {
        return "hotel-form"; // templates/hotel-form.html
    }

    @PostMapping
    public String addHotel(@RequestParam String name,
                           @RequestParam String city,
                           @RequestParam String address,
                           @RequestParam double rating) {
        Hotel hotel = new Hotel();
        hotel.setId(String.valueOf(System.currentTimeMillis()));
        hotel.setName(name);
        hotel.setCity(city);
        hotel.setAddress(address);
        hotel.setRating(rating);

        hotelRepository.save(hotel);

        return "redirect:/hotels";
    }
}
