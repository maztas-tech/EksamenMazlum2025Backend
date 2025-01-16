package product.eksamenmazlum2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.eksamenmazlum2025.model.Station;
import product.eksamenmazlum2025.repository.StationRepository;

import java.util.Comparator;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public Station getStationLowestDrone() {
        return stationRepository.findAll().stream()
                .min(Comparator.comparingInt(station -> station.getDroneList().size()))
                .orElse(null);
    }

}
