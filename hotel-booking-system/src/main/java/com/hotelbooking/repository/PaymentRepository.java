// repository/PaymentRepository.java
package com.hotelbooking.repository;

import com.hotelbooking.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> { }
