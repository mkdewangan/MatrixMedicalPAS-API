package com.mm.pas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mm.pas.entities.Patient;
import com.mm.pas.entities.User;
import com.mm.pas.repository.PatientRepository;

//@CrossOrigin  // now proxy setup in angular side at proxy.conf.json
@RestController
public class PatientController {
	
	@Autowired
    private PatientRepository patientRepo;
	
	
	@PostMapping("/api/patient")
    public Patient createPatient(@Valid @RequestBody Patient patient) {
        return patientRepo.save(patient);
    }
	
	@GetMapping("/api/patients")
    public List<Patient> getPatients() {
		
		System.out.println("PatientController.getPatients()");
		
        //Patient patient = new Patient();
        //patient.setPatientId(patientId);
		
		return patientRepo.findAll();
    }
	
	
	
	@GetMapping("/api/patient")
    public Patient getPatientByUserId(@RequestParam String userId) {
		
		System.out.println("PatientController.getPatientByUserId() " + userId);
		
        //Patient patient = new Patient();
        //patient.setPatientId(patientId);
		
		return patientRepo.findDistinctFirstByUserId(userId);
    }

	
	
}
