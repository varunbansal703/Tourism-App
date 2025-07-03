package com.techM.tourism_app.service;

import com.techM.tourism_app.model.Destination;
import com.techM.tourism_app.model.Hotel;
import com.techM.tourism_app.repository.DestinationRepository;
import com.techM.tourism_app.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public List<Hotel> getHotelsByDestinationId(Long destinationId) {
        Destination destination = destinationRepository.findById(destinationId).orElse(null);
        if (destination != null) {
            return hotelRepository.findByDestination(destination);
        }
        return List.of();
    }
}
