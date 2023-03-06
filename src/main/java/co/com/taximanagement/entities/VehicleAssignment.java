package co.com.taximanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vehicle_assignments")
@Data
public class VehicleAssignment implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	private User user;

	@OneToOne(fetch = FetchType.EAGER)
	private Vehicle vehicle;

	@Column(name = "assignment_date")
	private LocalDate assignmentDate;

	@Column(name = "finish_assignment_date")
	private LocalDate finishassignmentDate;
	
	@PrePersist
	public void actualDate() {
		assignmentDate = LocalDate.now();
	}
	
	private static final long serialVersionUID = 1L;
}
