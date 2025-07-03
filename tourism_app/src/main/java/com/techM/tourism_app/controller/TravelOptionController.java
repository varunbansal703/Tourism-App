package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.TravelOption;
import com.techM.tourism_app.service.TravelOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel-options")
@CrossOrigin(origins = "*")
public class TravelOptionController {

    @Autowired
    private TravelOptionService travelOptionService;

    // Add a travel option
    @PostMapping
    public TravelOption addTravelOption(@RequestBody TravelOption option) {
        return travelOptionService.saveTravelOption(option);
    }

    // Get all travel options
    @GetMapping
    public List<TravelOption> getAllTravelOptions() {
        return travelOptionService.getAllTravelOptions();
    }

    // Get options by destination ID
    @GetMapping("/destination/{destinationId}")
    public List<TravelOption> getOptionsByDestination(@PathVariable Long destinationId) {
        return travelOptionService.getTravelOptionsByDestinationId(destinationId);
    }
}
