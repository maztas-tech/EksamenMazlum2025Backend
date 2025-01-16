package product.eksamenmazlum2025.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.eksamenmazlum2025.model.Levering;

@Repository
public interface LeveringRepository extends JpaRepository<Levering, Integer> {
}
