package com.techM.tourism_app.repository;

import com.techM.tourism_app.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    // You can add custom query methods here if needed
}
