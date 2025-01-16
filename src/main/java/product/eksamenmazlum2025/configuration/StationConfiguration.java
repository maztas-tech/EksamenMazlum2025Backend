package product.eksamenmazlum2025.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import product.eksamenmazlum2025.model.Station;
import product.eksamenmazlum2025.repository.StationRepository;

@Component
public class StationConfiguration {

    @Autowired
    private StationRepository stationRepository;

    public void initializeStation() {
        Station station = new Station();

        station.setLatitude("55.410° N");
        station.setLongitude("12.330° E");

        stationRepository.save(station);

        Station station2 = new Station();
        station2.setLatitude("55.420° N");
        station2.setLongitude("12.350° E");

        stationRepository.save(station2);

        Station station3 = new Station();
        station3.setLatitude("55.400° N");
        station3.setLongitude("12.360° E");

        stationRepository.save(station3);
    }
}
