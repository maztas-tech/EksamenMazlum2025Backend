package product.eksamenmazlum2025.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialization implements CommandLineRunner {

    @Autowired
    private PizzaConfiguration pizzaConfiguration;
    @Autowired
    private StationConfiguration stationConfiguration;
    @Autowired
    private LeveringConfiguration leveringConfiguration;

    @Override
    public void run(String... args) throws Exception {
        pizzaConfiguration.initializePizza();
        stationConfiguration.initializeStation();
        leveringConfiguration.initializeLevering();
    }
}
