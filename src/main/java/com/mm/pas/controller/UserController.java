package com.mm.pas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mm.pas.entities.User;
import com.mm.pas.repository.UserRepository;

//@CrossOrigin  // now proxy setup in angular side at proxy.conf.json
@RestController
public class UserController {
	
	@Autowired
    private UserRepository userRepo;
	
	
	@PostMapping("/api/login")
    public User login(@Valid @RequestBody User user) {
		
		System.out.println("UserController.login() " + user);
		
		User userDB = userRepo.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		if(userDB != null) {
			System.out.println("UserDB "+ userDB.getUserId() + "  "+  userDB.getPassword());
		}else {
			
			System.out.println("Invalid Login");
		}
		
        return userDB;
    }
	
	
	@PostMapping("/api/user")
    public User createPatient(@Valid @RequestBody User user) {
        return userRepo.save(user);
    }
	
	@GetMapping("/api/users")
    public List<User> getUsers() {
		
		System.out.println("PatientController.getPatients()");
		
        //Patient patient = new Patient();
        //patient.setPatientId(patientId);
		
		return userRepo.findAll();
    }
	
	@GetMapping("/api/users/{id}") // GET HTTP method 
    public Optional<User> getUser(@PathVariable String id)
    {
        return userRepo.findById(id);
    }
	

}
