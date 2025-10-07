package com.hotelbooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.hotelbooking.service.HotelService;

@Controller
public class HomeController {
    private final HotelService HotelService;
    public HomeController(HotelService hotelService) { this.HotelService = hotelService; }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hotels", HotelService.findAll());
        return "index";
    }
}
