package product.eksamenmazlum2025.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.eksamenmazlum2025.model.Pizza;
import product.eksamenmazlum2025.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {


    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }
}
