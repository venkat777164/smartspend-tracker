package com.example.hotelbooking.repository;

import com.example.hotelbooking.model.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepository extends BaseRepository<Payment> {
    public Payment save(Payment payment) {
        return super.save(payment.getId(), payment);
    }
}
