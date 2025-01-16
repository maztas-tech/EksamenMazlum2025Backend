package product.eksamenmazlum2025.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import product.eksamenmazlum2025.model.Levering;
import product.eksamenmazlum2025.repository.LeveringRepository;

import java.time.LocalDateTime;

@Component
public class LeveringConfiguration {

    @Autowired
    private LeveringRepository leveringRepository;


    public void initializeLevering(){
        Levering levering = new Levering();

        levering.setAdresse("Glentevej 39");
        levering.setForventetLevering(LocalDateTime.now());
        levering.setFaktiskLevering(LocalDateTime.now().plusDays(1));

        leveringRepository.save(levering);

        Levering levering2 = new Levering();
        levering2.setAdresse("Glentevej 37");
        levering2.setForventetLevering(LocalDateTime.now());

        leveringRepository.save(levering2);

        Levering levering3 = new Levering();
        levering3.setAdresse("Hillerødvej 29");
        levering3.setForventetLevering(LocalDateTime.now().plusMinutes(45));

        leveringRepository.save(levering3);

        Levering levering4 = new Levering();
        levering4.setAdresse("Farumhovedgave 20");
        levering4.setForventetLevering(LocalDateTime.now().plusMinutes(60));

        leveringRepository.save(levering4);
    }
}
