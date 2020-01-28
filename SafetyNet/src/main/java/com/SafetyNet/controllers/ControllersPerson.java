package com.SafetyNet.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SafetyNet.SafetyNetApplication;
import com.SafetyNet.models.Persons;
import com.SafetyNet.models.SafetyNetModel;


@RestController
public class ControllersPerson {
		
		@PostMapping("/person")
		public SafetyNetModel addPersonn(@RequestBody Persons persons) {
			 
		SafetyNetModel safetyModel = SafetyNetApplication.model;
		safetyModel.getPersons().add(persons);

		return safetyModel;
		}
		
		
		@PutMapping("/person")
		public SafetyNetModel updatePerson(@RequestBody Persons persons) {
			SafetyNetModel safetyModel = SafetyNetApplication.model;
			String firstname = persons.getFirstName();
			String lastName = persons.getLastName();
			
			List<Persons> listPersons = safetyModel.getPersons();
			
			 for (Persons pers : listPersons) {
		            if(pers.getFirstName().equals(firstname) && pers.getLastName().equals(lastName)) {
		            	pers.setAddress(persons.getAddress());
		            	pers.setCity(persons.getCity());
		            	pers.setZip(persons.getZip());
		            	pers.setPhone(persons.getPhone());
		            	pers.setEmail(persons.getEmail());	
		            }
		        }

		    return safetyModel;
		}
		
		@DeleteMapping("/person")
		public SafetyNetModel deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
			//http://localhost:8080/person?firstName=John&lastName=Boyd
			SafetyNetModel safetyModel = SafetyNetApplication.model;
			
			List<Persons> listPersons = safetyModel.getPersons();

			int i=0;
			int j=0;
			 for (Persons pers : listPersons) {		 
		            if(pers.getFirstName().equals(firstName) && pers.getLastName().equals(lastName)) {
		            	i=j;	
		            }
		            i++;
		        }
			 
			listPersons.remove(j);
 			safetyModel.setPersons(listPersons);

		    return safetyModel;
		}
		
		
}
