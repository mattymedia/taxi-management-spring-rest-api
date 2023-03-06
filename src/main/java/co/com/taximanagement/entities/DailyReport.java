package co.com.taximanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "daily_reports")
@Data
public class DailyReport implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private VehicleAssignment vehicleAssignment;
		
    @Column(name = "daily_fee_received")
    private Double dailyFeeReceived;
    
	@Column(name = "report_detail")
	private String reportDetail;
	
	@Column(name = "report_date")
	private LocalDate reportDate;
	
	@PrePersist
	public void actualDate() {
		reportDate = LocalDate.now();
	}
	
	private static final long serialVersionUID = 1L;
}
