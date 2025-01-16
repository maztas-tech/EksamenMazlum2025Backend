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
import product.eksamenmazlum2025.model.enums.Driftstatus;
import product.eksamenmazlum2025.repository.DroneRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("dev")
class DroneServiceTest {

    @Mock
    private StationService stationService;

    @Mock
    private DroneRepository droneRepository;

    @InjectMocks
    private DroneService droneService;

    private Drone drone;

    public void setUp() {
        // Initialize the mocks and the Drone object
        MockitoAnnotations.initMocks(this);
        drone = new Drone();
        drone.setSerialUUID(UUID.randomUUID());
        drone.setDriftstatus(Driftstatus.I_DRIFT);
    }



    @Test
    @DisplayName("Drone cannot be added with no station")
    public void noStationAddDrone() {
        // When the stationService is called, return null (no station)
        when(stationService.getStationLowestDrone()).thenReturn(null);

        // Call the addDrone method
        HttpStatus result = droneService.addDrone(drone);

        // Verify that the result is HttpStatus.BAD_REQUEST
        assertEquals(HttpStatus.BAD_REQUEST, result);
    }
}