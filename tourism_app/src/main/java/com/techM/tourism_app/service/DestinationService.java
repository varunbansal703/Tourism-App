package com.techM.tourism_app.service;

import com.techM.tourism_app.model.Destination;

import java.util.List;

public interface DestinationService {
    Destination saveDestination(Destination destination);
    List<Destination> getAllDestinations();
    Destination getDestinationById(Long id);
}
