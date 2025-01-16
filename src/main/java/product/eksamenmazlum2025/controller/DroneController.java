package product.eksamenmazlum2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import product.eksamenmazlum2025.model.Drone;
import product.eksamenmazlum2025.service.DroneService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping("/drones")
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @PostMapping("/drones/add")
    public HttpStatus addNewDrone(Drone drone) {
        return droneService.addDrone(drone);
    }

    @PostMapping("/drones/enable/{id}")
    public HttpStatus enableDrone(@PathVariable int id) {
        return droneService.findDroneByIdEnable(id);
    }

    @PostMapping("/drones/disable/{id}")
    public HttpStatus disableDrone(@PathVariable int id) {
        return droneService.findDroneByIdDisable(id);
    }

    @PutMapping("/drones/retire/{id}")
    public HttpStatus retireDrone(@PathVariable int id) {
        return droneService.findDroneByIdRetire(id);
    }

}
