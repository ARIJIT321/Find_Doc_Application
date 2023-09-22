package com.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doc.exception.DoctorException;
import com.doc.model.Doctor;
import com.doc.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doc")
public class DoctorController {
	
	@Autowired 
	DoctorService docService;
	
	@PostMapping("/addDoc")
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) throws DoctorException {
		Doctor createdDoc = docService.createDoc(doctor);
        return new ResponseEntity<Doctor>(createdDoc, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/deleteDoc/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable Long id) throws DoctorException {
		Doctor deletedDoc = docService.deleteDoc(id);
        return new ResponseEntity<Doctor>(deletedDoc, HttpStatus.OK);
    }

}
