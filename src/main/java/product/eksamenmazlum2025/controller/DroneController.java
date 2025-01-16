package product.eksamenmazlum2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import product.eksamenmazlum2025.model.Drone;
import product.eksamenmazlum2025.service.DroneService;

import java.util.List;

@RestController
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping("/drones")
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }
}
