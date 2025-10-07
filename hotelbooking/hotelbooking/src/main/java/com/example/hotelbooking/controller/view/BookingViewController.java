package com.example.hotelbooking.controller.view;

import com.example.hotelbooking.model.Booking;
import com.example.hotelbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingViewController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public String listBookings(Model model) {
        List<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "bookings"; // templates/bookings.html
    }

    @GetMapping("/new")
    public String newBookingForm(@RequestParam String hotelId, Model model) {
        model.addAttribute("hotelId", hotelId);
        return "booking-form"; // templates/booking-form.html
    }

    @PostMapping
    public String createBooking(@RequestParam String hotelId,
                                @RequestParam String checkInDate,
                                @RequestParam String checkOutDate) {
        Booking booking = new Booking();
        booking.setId(String.valueOf(System.currentTimeMillis()));
        booking.setHotelId(hotelId);
        booking.setCheckInDate(LocalDate.parse(checkInDate));
        booking.setCheckOutDate(LocalDate.parse(checkOutDate));
        booking.setStatus("CONFIRMED");
        booking.setPaymentStatus("PENDING");

        bookingRepository.save(booking);

        return "redirect:/bookings";
    }
}
