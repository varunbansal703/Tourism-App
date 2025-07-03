package com.techM.tourism_app.repository;

import com.techM.tourism_app.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);  // auto-implemented by Spring JPA
}
