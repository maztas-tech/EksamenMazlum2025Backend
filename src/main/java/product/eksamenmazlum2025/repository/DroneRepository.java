package product.eksamenmazlum2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.eksamenmazlum2025.model.Drone;
import product.eksamenmazlum2025.model.enums.Driftstatus;

import java.util.Optional;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {
    Optional<Drone> findByDriftstatus(Driftstatus driftstatus);
}
