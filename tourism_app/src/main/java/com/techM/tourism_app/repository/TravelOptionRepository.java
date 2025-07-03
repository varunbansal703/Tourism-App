package com.techM.tourism_app.repository;

import com.techM.tourism_app.model.Destination;
import com.techM.tourism_app.model.TravelOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TravelOptionRepository extends JpaRepository<TravelOption, Long> {
    List<TravelOption> findByDestination(Destination destination);
}
