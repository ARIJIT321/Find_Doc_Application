package com.doc.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doc.enums.Cities;
import com.doc.enums.Dermatology;
import com.doc.enums.Ent;
import com.doc.enums.Gynecology;
import com.doc.enums.Orthopedic;
import com.doc.exception.DoctorException;
import com.doc.exception.PatientException;
import com.doc.model.Doctor;
import com.doc.model.Patients;
import com.doc.repo.DoctorRepo;
import com.doc.repo.PatientRepo;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	DoctorRepo docRepo;
	
	@Autowired
	PatientRepo patientRepo;

	@Override
	public Patients createPatients(Patients patient) throws PatientException {
		Patients newPatients = new Patients();
		newPatients.setName(patient.getName());
		newPatients.setCity(patient.getCity());
		newPatients.setEmail(patient.getEmail());
		newPatients.setPhoneNumber(patient.getPhoneNumber());
		newPatients.setSymptom(patient.getSymptom());
		
		return patientRepo.save(newPatients);
	}

	@Override
	public Patients deletePatients(Long Id) throws PatientException {
		Optional<Patients> deletePatient = patientRepo.findById(Id);
		if(deletePatient.isPresent()) {
			patientRepo.delete(deletePatient.get());
			return deletePatient.get();
		}
		throw new PatientException("There is no Patient with Id "+ Id);
	}

	@Override
	public List<Doctor> suggestDoc(Long Id) throws PatientException, DoctorException {
		Optional<Patients> patient = patientRepo.findById(Id);
		if(patient.isPresent()) {
			
			//This if condition takes the patient is present in these cities: Delhi, Noida, Faridabad
			
			if(Arrays.stream(Cities.values()).noneMatch(value->value.toString()
					.equalsIgnoreCase(patient.get().getCity()))){
				
	            throw new DoctorException("We are still waiting to expand to your location");
	        }else {// If they are present in cities like Delhi, Noida and Faridabad, then application enters to the else condition
	        	
	        	
	        	//First if condition checks if Symptom of patient lies in Orthopedic specialty.
	        	if(Arrays.stream(Orthopedic.values()).anyMatch(value->value.toString().toLowerCase()
						.contains(patient.get().getSymptom().toLowerCase())) ||
						
		                Arrays.stream(Orthopedic.values()).anyMatch(value->value.getDisplayName().trim()
		                		.equalsIgnoreCase(patient.get().getSymptom()))){
					
		            List<Doctor> doc = docRepo.findByCityAndSpeciality(patient.get().getCity(), "Orthopedic");
		            if(!doc.isEmpty()) {
		            	return doc;
		            }else {
		            	throw new DoctorException("There isn’t any doctor present at your location for your symptom");
		            }
		            
		        }//This else if condition checks if Symptom of patient lies in Gynecology specialty.
	        	else if(Arrays.stream(Gynecology.values()).anyMatch(value->value.toString().toLowerCase()
						.contains(patient.get().getSymptom().toLowerCase())) ||
						
		                Arrays.stream(Gynecology.values()).anyMatch(value->value.getDisplayName().trim()
		                		.equalsIgnoreCase(patient.get().getSymptom()))){
					
		            List<Doctor> doc = docRepo.findByCityAndSpeciality(patient.get().getCity(), "Gynecology");
		            if(!doc.isEmpty()) {
		            	return doc;
		            }else {
		            	throw new DoctorException("There isn’t any doctor present at your location for your symptom");
		            }
		        }//This else if condition checks if Symptom of patient lies in ENT specialty.
	        	else if(Arrays.stream(Ent.values()).anyMatch(value->value.toString().toLowerCase()
						.contains(patient.get().getSymptom().toLowerCase())) ||
						
		                Arrays.stream(Ent.values()).anyMatch(value->value.getDisplayName().trim()
		                		.equalsIgnoreCase(patient.get().getSymptom()))){
					
		            List<Doctor> doc = docRepo.findByCityAndSpeciality(patient.get().getCity(), "ENT");
		            if(!doc.isEmpty()) {
		            	return doc;
		            }else {
		            	throw new DoctorException("There isn’t any doctor present at your location for your symptom");
		            }
		        }//This else if condition checks if Symptom of patient lies in Dermatology specialty.
	        	else if(Arrays.stream(Dermatology.values()).anyMatch(value->value.toString().toLowerCase()
						.contains(patient.get().getSymptom().toLowerCase())) ||
						
		                Arrays.stream(Dermatology.values()).anyMatch(value->value.getDisplayName().trim()
		                		.equalsIgnoreCase(patient.get().getSymptom()))){
					
		            List<Doctor> doc = docRepo.findByCityAndSpeciality(patient.get().getCity(), "Dermatology");
		            if(!doc.isEmpty()) {
		            	return doc;
		            }else {
		            	throw new DoctorException("There isn’t any doctor present at your location for your symptom");
		            }
		        }
	        	else {
	        		throw new DoctorException("There isn’t any doctor present at your location for your symptom");
	        	}
	        	
	        	
	        }
			
		}
		throw new PatientException("There is no Patient with Id "+ Id);
	}

}
