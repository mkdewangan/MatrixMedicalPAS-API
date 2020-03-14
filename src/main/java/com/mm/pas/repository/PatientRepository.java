package com.mm.pas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.pas.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	Patient findDistinctFirstByUserId(String userId);
	
	

}
