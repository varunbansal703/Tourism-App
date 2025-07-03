package com.techM.tourism_app.service;

import com.techM.tourism_app.model.TravelOption;

import java.util.List;

public interface TravelOptionService {
    TravelOption saveTravelOption(TravelOption option);
    List<TravelOption> getAllTravelOptions();
    List<TravelOption> getTravelOptionsByDestinationId(Long destinationId);
}
