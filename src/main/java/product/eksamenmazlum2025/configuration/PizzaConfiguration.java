package product.eksamenmazlum2025.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import product.eksamenmazlum2025.model.Pizza;
import product.eksamenmazlum2025.repository.PizzaRepository;

@Component
public class PizzaConfiguration {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void initializePizza(){

        Pizza pizza = new Pizza();

        pizza.setTitel("Salat pizza");
        pizza.setPris(70);

        pizzaRepository.save(pizza);

        Pizza pizza2 = new Pizza();

        pizza2.setTitel("Americano");
        pizza2.setPris(70);

        pizzaRepository.save(pizza2);

        Pizza pizza3 = new Pizza();
        pizza3.setTitel("Mazlum special");
        pizza3.setPris(75);

        pizzaRepository.save(pizza3);
    }
}
