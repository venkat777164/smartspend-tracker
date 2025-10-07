package com.hotelbooking.service;

import com.hotelbooking.dto.BookingRequest;
import com.hotelbooking.model.*;
import com.hotelbooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

  @Autowired private BookingRepository bookingRepo;
  @Autowired private RoomRepository roomRepo;
  @Autowired private HotelRepository hotelRepo;
  @Autowired private UserRepository userRepo;
  @Autowired private PaymentRepository paymentRepo;

  private boolean overlaps(Booking b, BookingRequest req) {
    // overlap if (b.checkIn <= req.checkOut) && (b.checkOut >= req.checkIn)
    return !b.getCheckIn().isAfter(req.getCheckOut()) && !b.getCheckOut().isBefore(req.getCheckIn());
  }

  public int availableRooms(String roomId, BookingRequest req) {
    Room room = roomRepo.findById(roomId).orElseThrow(() -> new RuntimeException("Room not found"));
    List<Booking> booked = bookingRepo.findByRoomIdAndStatusIn(roomId, List.of("PENDING","CONFIRMED"));
    long countOverlapping = booked.stream().filter(b -> overlaps(b, req)).count();
    return room.getTotalRooms() - (int) countOverlapping;
  }

  public Booking createBooking(BookingRequest req) {
    userRepo.findById(req.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
    Room room = roomRepo.findById(req.getRoomId()).orElseThrow(() -> new RuntimeException("Room not found"));
    hotelRepo.findById(req.getHotelId()).orElseThrow(() -> new RuntimeException("Hotel not found"));

    long nights = ChronoUnit.DAYS.between(req.getCheckIn(), req.getCheckOut());
    if (nights <= 0) throw new RuntimeException("Invalid date range");

    int avail = availableRooms(req.getRoomId(), req);
    if (avail <= 0) throw new RuntimeException("No rooms available");

    double amount = nights * room.getPricePerNight();

    Booking booking = new Booking();
    booking.setUserId(req.getUserId());
    booking.setHotelId(req.getHotelId());
    booking.setRoomId(req.getRoomId());
    booking.setCheckIn(req.getCheckIn());
    booking.setCheckOut(req.getCheckOut());
    booking.setStatus("PENDING");
    booking.setAmount(amount);
    return bookingRepo.save(booking);
  }

  public Payment pay(String bookingId, double amount) {
    Booking b = bookingRepo.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
    // dummy: accept payment if amount >= booking.amount
    String status = amount >= b.getAmount() ? "SUCCESS" : "FAILED";
    if ("SUCCESS".equals(status)) {
      b.setStatus("CONFIRMED");
      bookingRepo.save(b);
    }
    Payment p = new Payment();
    p.setBookingId(b.getId());
    p.setAmount(amount);
    p.setStatus(status);
    p.setPaymentRef(UUID.randomUUID().toString());
    p.setTimestamp(java.time.LocalDateTime.now());
    return paymentRepo.save(p);
  }

  public void cancel(String bookingId) {
    Booking b = bookingRepo.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
    b.setStatus("CANCELLED");
    bookingRepo.save(b);
  }
}
