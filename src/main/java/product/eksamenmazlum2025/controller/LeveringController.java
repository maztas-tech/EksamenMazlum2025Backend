package product.eksamenmazlum2025.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import product.eksamenmazlum2025.model.Levering;
import product.eksamenmazlum2025.service.LeveringService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LeveringController {

    @Autowired
    private LeveringService leveringService;

    @GetMapping("/deliveriesNotDelivered")
    public List<Levering> getLeveringsNotDelivered() {
        return leveringService.getAllLeveringNotDelivered();
    }

    @GetMapping("/deliveries/queue")
    public List<Levering> queuedDeliveriesWithNoDrones() {
        return leveringService.queuedDeliveriesWithNoDrones();
    }

    @PostMapping("/deliveries/add/{pizzaID}")
    public HttpStatus addLevering(Levering levering, @PathVariable int pizzaID) {
        return leveringService.addLevering(levering, pizzaID);
    }

    @PostMapping("/deliveries/schedule/{leveringID}")
    public HttpStatus addDroneToDelivery(@PathVariable int leveringID) {
        return leveringService.addDroneToLevering(leveringID);
    }

    @PostMapping("/deliveries/finish/{leveringsID}")
    public HttpStatus finishLevering(@PathVariable int leveringsID) {
        return leveringService.finishLevering(leveringsID);
    }
}
