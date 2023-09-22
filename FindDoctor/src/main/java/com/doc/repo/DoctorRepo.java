package com.doc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doc.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long>{

	@Query("SELECT d FROM Doctor d WHERE d.city = :city AND d.speciality = :speciality")
    public List<Doctor> findByCityAndSpeciality(String city, String speciality);
	
}
