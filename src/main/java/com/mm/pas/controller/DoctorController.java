package com.mm.pas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.pas.entities.Doctor;
import com.mm.pas.entities.Patient;
import com.mm.pas.repository.DoctorRepository;
import com.mm.pas.repository.PatientRepository;

//@CrossOrigin // now proxy setup in angular side at proxy.conf.json
@RestController
public class DoctorController {
	
	@Autowired
    private DoctorRepository doctorRepo;
	
	
	@PostMapping("/api/doctor")
    public Doctor createDoctor(@Valid @RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }
	
	@GetMapping("/api/doctors")
    public List<Doctor> getDoctors() {
		
		System.out.println("DoctorController.getDoctors()");
		
		List<Doctor> doctorList = doctorRepo.findAll();
		
		System.out.println("DoctorController.getDoctors() " + doctorList.size());
	
		//return doctorRepo.findAll();
		
		return doctorList;
    }
	
	
	@GetMapping("/api/doctor")
    public Doctor getDoctorByUserId(@RequestParam String userId) {
		
		System.out.println("PatientController.getPatientByUserId() " + userId);
		
        //Patient patient = new Patient();
        //patient.setPatientId(patientId);
		
		return doctorRepo.findDistinctFirstByUserId(userId);
    }

}
