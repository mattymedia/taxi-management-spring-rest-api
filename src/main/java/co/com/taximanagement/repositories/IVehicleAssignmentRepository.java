package co.com.taximanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.taximanagement.entities.VehicleAssignment;

public interface IVehicleAssignmentRepository extends JpaRepository<VehicleAssignment, Integer> {

}
