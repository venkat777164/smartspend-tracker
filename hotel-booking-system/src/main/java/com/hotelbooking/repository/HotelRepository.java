// repository/HotelRepository.java
package com.hotelbooking.repository;

import com.hotelbooking.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {
  List<Hotel> findByCityIgnoreCase(String city);
}
