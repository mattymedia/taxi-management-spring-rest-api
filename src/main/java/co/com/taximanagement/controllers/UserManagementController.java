package co.com.taximanagement.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.taximanagement.entities.Role;
import co.com.taximanagement.entities.User;
import co.com.taximanagement.entities.UserProfile;
import co.com.taximanagement.repositories.IRoleRepository;
import co.com.taximanagement.repositories.IUserProfileRepository;
import co.com.taximanagement.repositories.IUserRepository;
import co.com.taximanagement.services.IUploadService;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserManagementController {

	private IUserRepository userRepository;
	private IRoleRepository roleRepository;
	private IUserProfileRepository profileRepository;
	private IUploadService uploadService;
	
	@GetMapping("/roles")
	public List<Role> findAllRoles(){
		return roleRepository.findAll();
	}
	
	
	@GetMapping("/show-all")
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	
	@GetMapping("/search-id/{id}")
	public User findById(@PathVariable Integer id) {		
		return userRepository.findById(id).orElse(null);
	}
	
	
	@GetMapping("/search-username/{username}")
	public User findById(@PathVariable String username) {		
		return userRepository.findByUsername(username);
	}
	
	
	@PostMapping("/save")
	public User saveUser(@RequestPart("archive") MultipartFile file, @RequestPart("user") Request request) {
		User user = request.getUser();
		UserProfile userProfile = request.getUserProfile(); 
		String fileName = "";
		
		try {
			fileName = uploadService.copy(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Role> roles = user.getRoles();
		List<Integer> idRole = new ArrayList<>();
		
		for(Role role : roles) {
			idRole.add(role.getId());
		}	
		
		userProfile.setUrlPhoto(fileName);
		profileRepository.save(userProfile);
		user.setRoles(roleRepository.findAllById(idRole));
		user.setProfile(userProfile);
		
		
		return userRepository.save(request.getUser());
		
	}	
}

@Data
class Request {
	private User user;
	private UserProfile userProfile;
}
