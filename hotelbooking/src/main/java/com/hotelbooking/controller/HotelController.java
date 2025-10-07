package com.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hotelbooking.service.HotelService;

@Controller
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService service;
    public HotelController(HotelService service) { this.service = service; }

    @GetMapping
    public String list(@RequestParam(value="city", required=false) String city, Model model) {
        model.addAttribute("hotels", city == null ? service.findAll() : service.findByCity(city));
        return "hotels";
    }

    @GetMapping("/{id}")
    public String details(@PathVariable String id, Model model) {
        service.findById(id).ifPresent(h -> model.addAttribute("hotel", h));
        return "hotel-details";
    }
}
