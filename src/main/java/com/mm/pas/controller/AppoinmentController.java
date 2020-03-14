package com.mm.pas.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mm.pas.entities.Appointment;
import com.mm.pas.entities.Patient;
import com.mm.pas.repository.AppointmentRepository;

//@CrossOrigin  // now proxy setup in angular side at proxy.conf.json
@RestController
public class AppoinmentController {

	@Autowired
	private AppointmentRepository appointmentRepo;

	@PostMapping("/api/appointment")
	public Appointment createAppointment(@Valid @RequestBody Appointment appoinment) {

		System.out.println("appointment from ui" + appoinment);

		String confCode = getConfirmationCode();

		appoinment.setConfCode(confCode);

		return appointmentRepo.save(appoinment);
	}
	
	
	
	@PutMapping("/api/appointment/reschedule")
	public Appointment rescheduleAppointment(@Valid @RequestBody Appointment appoinment) {

		System.out.println("appointment from ui" + appoinment);
		
		Integer appointmentId = appoinment.getAppointmentId();
		
		Appointment appointmentDB = appointmentRepo.findById(appointmentId).get();
		
		
		
		System.out.println("AppointmentDB " + appointmentDB);
	
		appointmentDB.setStatus("RESCH");
		//appointmentRepo.saveAndFlush(appointmentDB);
		

		Appointment appointment2 = new Appointment();
		//appointment2.setDoctorId(appointment2.get);
		
		String confCode = getConfirmationCode();

		appoinment.setConfCode(confCode);

	    return appointmentRepo.save(appoinment);
		
		//return appointmentDB;
	}
	

	/*
	 * @GetMapping("/appointments") public List<Appointment> getAppointments() {
	 * 
	 * List<Appointment> appoinmentList = appointmentRepo.findAll();
	 * 
	 * // return doctorRepo.findAll();
	 * 
	 * return appoinmentList; }
	 */

	@GetMapping("/api/appointments")
	public List<Appointment> getAppointments(@RequestParam Integer doctorId) {
		List<Appointment> appoinmentList = new ArrayList<Appointment>();

		if (doctorId == null) {

			appoinmentList = appointmentRepo.findAll();

		} else {

			appoinmentList = appointmentRepo.findByDoctorId(doctorId);

		}

		// List<Appointment> appoinmentList = appointmentRepo.findByDoctorId(doctorId);

		// return doctorRepo.findAll();

		return appoinmentList;
	}

	@GetMapping("/api/appointments/patients")
	public Set<Patient> getPatients(@RequestParam Integer doctorId) {

		List<Appointment> appoinmentList = new ArrayList<Appointment>();

		appoinmentList = appointmentRepo.findByDoctorId(doctorId);

		Set<Patient> patientList = new HashSet<Patient>();

		for (Appointment appointment : appoinmentList) {

			patientList.add(appointment.getPatient());

		}

		return patientList;
	}

	@GetMapping("/api/appointment")
	public Appointment getAppointmentByConfCode(@RequestParam String confCode) {

		System.out.println("PatientController.getPatientByUserId() " + confCode);

		// Patient patient = new Patient();
		// patient.setPatientId(patientId);

		return appointmentRepo.findDistinctFirstByConfCode(confCode);
	}

	private String getConfirmationCode() {

		int confCode = 10000 + new Random().nextInt(90000);

		return confCode + "";
	}

}
