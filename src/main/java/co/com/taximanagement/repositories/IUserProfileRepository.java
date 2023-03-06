package co.com.taximanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.taximanagement.entities.UserProfile;

public interface IUserProfileRepository extends JpaRepository<UserProfile, Integer>{

}
