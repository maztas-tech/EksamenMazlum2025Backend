package product.eksamenmazlum2025.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import product.eksamenmazlum2025.model.Pizza;
import product.eksamenmazlum2025.repository.PizzaRepository;
import product.eksamenmazlum2025.service.PizzaService;

import java.util.List;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/pizza")
    public List<Pizza> getAllPizza() {
        return pizzaService.getAllPizza();
    }
}
