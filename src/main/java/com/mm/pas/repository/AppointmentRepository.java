package com.mm.pas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.pas.entities.Appointment;
import com.mm.pas.entities.Doctor;



public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	
	Appointment findDistinctFirstByConfCode(String confCode);
	
	List<Appointment> findByDoctorId(Integer doctorId);
	
	

}
