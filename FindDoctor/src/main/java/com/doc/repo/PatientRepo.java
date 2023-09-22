package com.doc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doc.model.Patients;

@Repository
public interface PatientRepo extends JpaRepository<Patients, Long>{

	public Patients findByCity(String city);
	
	public Patients findBySymptom(String symptom);
	
}
