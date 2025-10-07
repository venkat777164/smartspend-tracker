// repository/BookingRepository.java
package com.hotelbooking.repository;

import com.hotelbooking.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
  List<Booking> findByUserId(String userId);

  // Overlap query approximation via derived methods isn't perfect for ranges in Mongo repos.
  // We'll filter overlap in service.
  List<Booking> findByRoomIdAndStatusIn(String roomId, List<String> statuses);
}
