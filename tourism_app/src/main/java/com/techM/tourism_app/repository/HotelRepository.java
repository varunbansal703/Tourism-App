package com.techM.tourism_app.repository;

import com.techM.tourism_app.model.Hotel;
import com.techM.tourism_app.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByDestination(Destination destination);
}
