package com.mm.pas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.pas.entities.Doctor;
import com.mm.pas.entities.Patient;


public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	Doctor findDistinctFirstByUserId(String userId);

}
