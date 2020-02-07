package com.SafetyNet.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SafetyNet.SafetyNetApplication;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Persons;
import com.SafetyNet.models.SafetyNetModel;

@RestController
public class ControllersFirestations {
	
	@PostMapping("/firestation")
	public SafetyNetModel addPersonn(@RequestBody Firestations firestation) {
		 
	SafetyNetModel safetyModel = SafetyNetApplication.model;
	safetyModel.getFirestations().add(firestation);

	return safetyModel;
	}
	
	
	@PutMapping("/firestation")
	public SafetyNetModel updatePerson(@RequestBody Firestations firestation) {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
		String address = firestation.getAddress();
		
		
		List<Firestations> listFirestation = safetyModel.getFirestations();
		
		 for (Firestations fire : listFirestation) {
	            if(fire.getAddress().equals(address)) {
	            	fire.setStation(firestation.getStation());		
	            }
	        }

	    return safetyModel;
	}
	
	@DeleteMapping("/firestation")
	public SafetyNetModel deleteFirestation(@RequestParam String address) {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
		
		List<Firestations> listFirestation = safetyModel.getFirestations();

		int i=0;
		int j=0;
		 for (Firestations fire : listFirestation) {		 
	            if(fire.getAddress().equals(address)) {
	            	i=j;	
	            }
	            i++;
	        }
		 
		 listFirestation.remove(j);
		 

	    return safetyModel;
	}
}
