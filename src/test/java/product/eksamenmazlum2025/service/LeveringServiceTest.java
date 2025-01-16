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

    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.initMocks(this);

        // Create a sample drone
        drone = new Drone();
        drone.setDroneID(1);
        drone.setDriftstatus(Driftstatus.I_DRIFT);

        // Create a sample delivery (Levering)
        levering = new Levering();
        levering.setLeveringID(1);
        levering.setDrone(null);
    }

    @Test
    @DisplayName("Add drone to delivery ")
    public void testAddDroneToLevering_DeliveryNotFound() {
        // Mock the repository to return empty when looking for a delivery
        when(leveringRepository.findById(1)).thenReturn(Optional.empty());

        // Call the method
        HttpStatus result = leveringService.addDroneToLevering(1);

        // Assert the result is BAD_REQUEST because no delivery was found
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }


}