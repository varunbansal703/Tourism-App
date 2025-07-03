package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.Destination;
import com.techM.tourism_app.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinations")
@CrossOrigin(origins = "*")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    // Add a new destination
    @PostMapping
    public Destination addDestination(@RequestBody Destination destination) {
        return destinationService.saveDestination(destination);
    }

    // Get all destinations
    @GetMapping
    public List<Destination> getAllDestinations() {
        return destinationService.getAllDestinations();
    }

    // Get destination by ID
    @GetMapping("/{id}")
    public Destination getDestinationById(@PathVariable Long id) {
        return destinationService.getDestinationById(id);
    }
}
