package com.doc.service;


import java.util.List;

import com.doc.exception.DoctorException;
import com.doc.exception.PatientException;
import com.doc.model.Doctor;
import com.doc.model.Patients;

public interface PatientService {

	public Patients createPatients(Patients patient) throws PatientException;
	
	public Patients deletePatients(Long Id) throws PatientException;
	
	public List<Doctor> suggestDoc(Long Id) throws PatientException,DoctorException;

}
