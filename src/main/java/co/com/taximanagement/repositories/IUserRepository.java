package co.com.taximanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.taximanagement.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findByUsername(String username);
}
