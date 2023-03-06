package co.com.taximanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.taximanagement.entities.Vehicle;
import co.com.taximanagement.entities.VehicleAssignment;
import co.com.taximanagement.entities.VehicleMro;
import co.com.taximanagement.repositories.IVehicleAssignmentRepository;
import co.com.taximanagement.repositories.IVehicleMroRepository;
import co.com.taximanagement.repositories.IVehicleRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/vehicle")
@AllArgsConstructor
public class VehicleManagementController {

	private IVehicleRepository vehicleRepository;
	private IVehicleAssignmentRepository assignmentRepository;
	private IVehicleMroRepository mroRepository;
	
	
	@GetMapping("/show-all")
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	
	@GetMapping("/search-registration/{registration}")
	public Optional<Vehicle> findByRegistration(@PathVariable String registration){
		return vehicleRepository.findByRegistration(registration);
	}
	
	@GetMapping("/search-mro/{registration}")
	public Optional<List<VehicleMro>> findMroByRegistration(@PathVariable String registration){
		return mroRepository.findMroByRegistration(registration);
	}
	
	
	@PostMapping("/save-mro")
	public VehicleMro saveMro(@RequestBody VehicleMro vehicleMro) {
		return mroRepository.save(vehicleMro);
	}
	
	
	@PostMapping("/save-assignment")
	public String saveVehicleAssignment(@RequestBody VehicleAssignment assignment) {
		assignmentRepository.save(assignment);
		return "the assignment has been successfully saved in the database.";
	}
}
