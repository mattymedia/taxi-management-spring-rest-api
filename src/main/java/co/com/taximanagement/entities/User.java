package co.com.taximanagement.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"),
	uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id" }))
	private List<Role> roles;

	@OneToOne(fetch = FetchType.EAGER)
	private UserProfile profile;

	private String username;

	private String password;

	@Column(name = "create_at")
	private LocalDate createAt;

	@PrePersist
	public void actualDate() {
		createAt = LocalDate.now();
	}

	private static final long serialVersionUID = 1L;

}
