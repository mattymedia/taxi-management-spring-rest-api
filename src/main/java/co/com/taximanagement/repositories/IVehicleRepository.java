package co.com.taximanagement.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.taximanagement.entities.Vehicle;

public interface IVehicleRepository extends JpaRepository<Vehicle, Integer> {

	@Query("SELECT v FROM Vehicle v WHERE v.registration = ?1")
	Optional<Vehicle> findByRegistration(String registration);
}
