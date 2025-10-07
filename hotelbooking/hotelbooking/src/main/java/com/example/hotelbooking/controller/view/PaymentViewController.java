package com.example.hotelbooking.controller.view;

import com.example.hotelbooking.model.Payment;
import com.example.hotelbooking.model.Booking;
import com.example.hotelbooking.repository.PaymentRepository;
import com.example.hotelbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/payments")
public class PaymentViewController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public String listPayments(Model model) {
        List<Payment> payments = paymentRepository.findAll();
        model.addAttribute("payments", payments);
        return "payments"; // templates/payments.html
    }

    @GetMapping("/new")
    public String newPaymentForm(@RequestParam String bookingId, Model model) {
        model.addAttribute("bookingId", bookingId);
        return "payment-form"; // templates/payment-form.html
    }

    @PostMapping
    public String makePayment(@RequestParam String bookingId,
                              @RequestParam double amount) {
        Payment payment = new Payment();
        payment.setId(String.valueOf(System.currentTimeMillis()));
        payment.setBookingId(bookingId);
        payment.setAmount(amount);

        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (amount > 0) {
            payment.setStatus("SUCCESS");
            if (booking != null) booking.setPaymentStatus("PAID");
        } else {
            payment.setStatus("FAILED");
            if (booking != null) booking.setPaymentStatus("FAILED");
        }

        paymentRepository.save(payment);
        if (booking != null) bookingRepository.save(booking);

        return "redirect:/payments";
    }
}
