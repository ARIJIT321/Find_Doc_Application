package com.doc.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.enums.Cities;
import com.doc.enums.Speciality;
import com.doc.exception.DoctorException;
import com.doc.model.Doctor;
import com.doc.repo.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRepo docRepo;

	@Override
	public Doctor createDoc(Doctor doc) throws DoctorException {
		
		if(Arrays.stream(Cities.values()).noneMatch(value->value.toString()
				.equalsIgnoreCase(doc.getCity()))) {
			throw new DoctorException("Only doctors from Delhi, Noida and Faridabad can join the application");
			
		}else if(Arrays.stream(Speciality.values()).noneMatch(value->value.toString()
				.equalsIgnoreCase(doc.getSpeciality()))) {
			throw new DoctorException("Only doctors with specialities like Orthopedic, Gynecology, Dermatology and ENT can join the application");
			
		}
		else {
			Doctor newDoc = new Doctor();
			newDoc.setName(doc.getName());
			newDoc.setCity(doc.getCity());
			newDoc.setEmail(doc.getEmail());
			newDoc.setPhoneNumber(doc.getPhoneNumber());
			newDoc.setSpeciality(doc.getSpeciality());
			
			return docRepo.save(newDoc);
		}
	}

	@Override
	public Doctor deleteDoc(Long Id) throws DoctorException {
		Optional<Doctor> deleteDoc = docRepo.findById(Id);
		if(deleteDoc.isPresent()) {
			docRepo.delete(deleteDoc.get());
			return deleteDoc.get();
		}
		throw new DoctorException("There is no doctor with Id "+ Id);
	}

}
