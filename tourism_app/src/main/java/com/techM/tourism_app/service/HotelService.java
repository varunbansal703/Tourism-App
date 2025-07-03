package com.techM.tourism_app.service;

import com.techM.tourism_app.model.Hotel;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    List<Hotel> getHotelsByDestinationId(Long destinationId);
}
