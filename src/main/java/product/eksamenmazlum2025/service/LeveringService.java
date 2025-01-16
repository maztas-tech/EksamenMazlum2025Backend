package product.eksamenmazlum2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import product.eksamenmazlum2025.model.Drone;
import product.eksamenmazlum2025.model.Levering;
import product.eksamenmazlum2025.model.Pizza;
import product.eksamenmazlum2025.model.enums.Driftstatus;
import product.eksamenmazlum2025.repository.DroneRepository;
import product.eksamenmazlum2025.repository.LeveringRepository;
import product.eksamenmazlum2025.repository.PizzaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LeveringService {

    @Autowired
    private LeveringRepository leveringRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private DroneRepository droneRepository;

    public List<Levering> getAllLeveringNotDelivered() {
        return leveringRepository.findAll().stream()
                .filter(levering -> Objects.isNull(levering.getFaktiskLevering()))
                .toList();
    }

    public HttpStatus addLevering(Levering levering, int pizzaID) {
        Optional<Pizza> pizza = pizzaRepository.findById(pizzaID);
        try {
            if (pizza.isPresent()) {
                levering.setForventetLevering(LocalDateTime.now().plusMinutes(30));
                levering.setAdresse("Farummidtpunkt 210 D");
                levering.setPizza(pizza.get());

                leveringRepository.save(levering);

                return HttpStatus.OK;
            }
        } catch (Exception e) {
            System.out.println("Der gik noget galt: " + e.getMessage());
        }

        return HttpStatus.BAD_REQUEST;
    }


    public List<Levering> queuedDeliveriesWithNoDrones() {
        return leveringRepository.findAll().stream()
                .filter(levering -> Objects.isNull(levering.getDrone()))
                .toList();
    }

    public HttpStatus addDroneToLevering(int leveringID) {
        //Find alle de droner, som indgår i en aktiv levering.
        Set<Integer> occupiedDrones = leveringRepository.findAll().stream()
                .filter(levering -> Objects.nonNull(levering.getDrone()) && Objects.isNull(levering.getFaktiskLevering()))
                .map(levering -> levering.getDrone().getDroneID())
                .collect(Collectors.toSet());
        //Find alle registrerede droner som ikke indgår i aktiv levering og er i drift.
        Optional<Drone> allocatedDrone = droneRepository.findAll()
                .stream()
                .filter(drone -> drone.getDriftstatus() == Driftstatus.I_DRIFT && !occupiedDrones.contains(drone.getDroneID()))
                .findFirst();

        Optional<Levering> levering = leveringRepository.findById(leveringID);

        if (!allocatedDrone.isPresent()) {
            //TODO: throw custom no drones available exception.
            return HttpStatus.BAD_REQUEST;
        }

        if(levering.isPresent()) {
            if (Objects.nonNull(levering.get().getDrone())) {
                return HttpStatus.BAD_REQUEST;
            } else {
                levering.get().setDrone(allocatedDrone.get());
                leveringRepository.save(levering.get());
                return HttpStatus.OK;
            }
        }
        return HttpStatus.BAD_REQUEST;
    }

    public HttpStatus finishLevering(int leveringID) {
        Optional<Levering> levering = leveringRepository.findById(leveringID);

        if (levering.isPresent() && Objects.nonNull(levering.get().getDrone())) {
            levering.get().setFaktiskLevering(LocalDateTime.now());
            leveringRepository.save(levering.get());
            return HttpStatus.OK;
        }else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
