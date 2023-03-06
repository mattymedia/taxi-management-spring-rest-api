package co.com.taximanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "vechicle_mro")
@Data
public class VehicleMro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	@Column(name = "detail_mro")
	private String detailMro;

	@Column(name = "realization_date")
	private LocalDate realizationDate;

	@Column(name = "current_mileage")
	private Long currentMileage;

	@PrePersist
	public void actualDate() {
		realizationDate = LocalDate.now();
	}
	
	private static final long serialVersionUID = 1L;

}
