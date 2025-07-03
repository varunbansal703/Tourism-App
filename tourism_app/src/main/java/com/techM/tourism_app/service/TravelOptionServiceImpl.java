package com.techM.tourism_app.service;

import com.techM.tourism_app.model.Destination;
import com.techM.tourism_app.model.TravelOption;
import com.techM.tourism_app.repository.DestinationRepository;
import com.techM.tourism_app.repository.TravelOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelOptionServiceImpl implements TravelOptionService {

    @Autowired
    private TravelOptionRepository travelOptionRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public TravelOption saveTravelOption(TravelOption option) {
        return travelOptionRepository.save(option);
    }

    @Override
    public List<TravelOption> getAllTravelOptions() {
        return travelOptionRepository.findAll();
    }

    @Override
    public List<TravelOption> getTravelOptionsByDestinationId(Long destinationId) {
        Destination destination = destinationRepository.findById(destinationId).orElse(null);
        return (destination != null)
            ? travelOptionRepository.findByDestination(destination)
            : List.of();
    }
}
