package com.techM.tourism_app.controller;

import com.techM.tourism_app.model.Hotel;
import com.techM.tourism_app.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Add a hotel
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // Get all hotels
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // Get hotels by destination ID
    @GetMapping("/destination/{destinationId}")
    public List<Hotel> getHotelsByDestination(@PathVariable Long destinationId) {
        return hotelService.getHotelsByDestinationId(destinationId);
    }
}
