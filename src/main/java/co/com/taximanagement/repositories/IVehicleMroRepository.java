package co.com.taximanagement.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.taximanagement.entities.VehicleMro;

public interface IVehicleMroRepository extends JpaRepository<VehicleMro, Integer> {
	@Query("SELECT m FROM VehicleMro m WHERE m.vehicle.registration = ?1")
	Optional<List<VehicleMro>> findMroByRegistration(String registration);
}
