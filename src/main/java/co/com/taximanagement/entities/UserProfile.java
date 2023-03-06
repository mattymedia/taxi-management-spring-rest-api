package co.com.taximanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "user_profile")
@Data
public class UserProfile implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "id_card")
	private Long idCard;

	private String name;

	private String surname;

	private String email;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "residence_address")
	private String residenceAddress;

	@Column(name = "uri_photo")
	private String urlPhoto;
	
	private static final long serialVersionUID = 1L;

}
