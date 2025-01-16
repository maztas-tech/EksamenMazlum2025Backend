package product.eksamenmazlum2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.eksamenmazlum2025.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer> {
}
