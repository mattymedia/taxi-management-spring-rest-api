package co.com.taximanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.taximanagement.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}
