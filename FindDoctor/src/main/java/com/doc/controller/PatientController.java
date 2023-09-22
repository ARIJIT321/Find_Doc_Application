package com.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.exception.DoctorException;
import com.doc.exception.PatientException;
import com.doc.model.Doctor;
import com.doc.model.Patients;
import com.doc.service.DoctorService;
import com.doc.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired 
	DoctorService docService;
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/addPatients")
    public ResponseEntity<Patients> addPatient(@Valid @RequestBody Patients patient) throws PatientException {
		Patients createdPatients = patientService.createPatients(patient);
        return new ResponseEntity<Patients>(createdPatients, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Patients> deletePatient(@PathVariable Long id) throws PatientException {
		Patients deletedPatients = patientService.deletePatients(id);
        return new ResponseEntity<Patients>(deletedPatients, HttpStatus.ACCEPTED);
    }
	
	@GetMapping("suggestDoc/{id}")
	public ResponseEntity<List<Doctor>> suggestDoc(@PathVariable Long id) throws PatientException, DoctorException{
		List<Doctor> docList = patientService.suggestDoc(id);
		
		return new ResponseEntity<List<Doctor>>(docList,HttpStatus.ACCEPTED);
	}
	
}
