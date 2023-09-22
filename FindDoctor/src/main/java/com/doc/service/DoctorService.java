package com.doc.service;

import com.doc.exception.DoctorException;
import com.doc.model.Doctor;

public interface DoctorService {

	public Doctor createDoc(Doctor doc) throws DoctorException;
	
	public Doctor deleteDoc(Long Id) throws DoctorException;
}
