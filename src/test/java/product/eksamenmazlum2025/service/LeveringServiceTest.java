package product.eksamenmazlum2025.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import product.eksamenmazlum2025.model.Drone;
import product.eksamenmazlum2025.model.Levering;
import product.eksamenmazlum2025.model.enums.Driftstatus;
import product.eksamenmazlum2025.repository.DroneRepository;
import product.eksamenmazlum2025.repository.LeveringRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("dev")
class LeveringServiceTest {
    @Mock
    private LeveringRepository leveringRepository;

    @Mock
    private DroneRepository droneRepository;

    @InjectMocks
    private LeveringService leveringService;

    private Drone drone;
    private Levering levering;

    /*
    Set up mock with init
    Create drone instances and set their values
    Create levering instances and set their values
     */
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        drone = new Drone();
        drone.setDroneID(1);
        drone.setDriftstatus(Driftstatus.I_DRIFT);

        levering = new Levering();
        levering.setLeveringID(1);
        levering.setDrone(null);
    }

    /*
    Create a unit test to see if a drone can be created with no delivery instance
    and use assertEquals with their result in HTTP status
     */

    @Test
    @DisplayName("Add drone to delivery ")
    public void testAddDroneToLevering_DeliveryNotFound() {
        when(leveringRepository.findById(1)).thenReturn(Optional.empty());

        HttpStatus result = leveringService.addDroneToLevering(1);

        assertEquals(HttpStatus.BAD_REQUEST, result);
    }


}