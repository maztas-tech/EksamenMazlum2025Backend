package product.eksamenmazlum2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import product.eksamenmazlum2025.model.Drone;
import product.eksamenmazlum2025.model.Station;
import product.eksamenmazlum2025.model.enums.Driftstatus;
import product.eksamenmazlum2025.repository.DroneRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    @Autowired
    private StationService stationService;

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    /*
    Gemmer en drone, der generer en randomUUID
    Dens driftstatus bliver sat til I_DRIFT
     */
    public HttpStatus addDrone(Drone drone) {
        Station station = stationService.getStationLowestDrone();

        try {
            if (Objects.nonNull(station)) {
                drone.setSerialUUID(UUID.randomUUID());
                drone.setDriftstatus(Driftstatus.I_DRIFT);
                drone.setStation(station);

                droneRepository.save(drone);
                return HttpStatus.OK;
            }
            //Kig på forskellige måder at håndtere exceptions på
        } catch (Exception e) {
            System.out.println("Oprettelse af drone fejlede: " + e.getMessage());
        }

        return HttpStatus.BAD_REQUEST;
    }

    public HttpStatus findDroneByIdEnable(int id) {
        Optional<Drone> drone = droneRepository.findById(id);
        if (drone.isPresent()) {
            drone.get().setDriftstatus(Driftstatus.I_DRIFT);
            droneRepository.save(drone.get());

            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }

    public HttpStatus findDroneByIdDisable(int id) {
        Optional<Drone> drone = droneRepository.findById(id);
        if (drone.isPresent()) {
            drone.get().setDriftstatus(Driftstatus.UDE_AF_DRIFT);
            droneRepository.save(drone.get());

            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }

    public HttpStatus findDroneByIdRetire(int id) {
        Optional<Drone> drone = droneRepository.findById(id);
        if (drone.isPresent()) {
            drone.get().setDriftstatus(Driftstatus.UDFASET);
            droneRepository.save(drone.get());

            return HttpStatus.OK;
        }

        return HttpStatus.NOT_FOUND;
    }
}
