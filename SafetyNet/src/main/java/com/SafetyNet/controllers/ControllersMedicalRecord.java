package com.SafetyNet.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SafetyNet.SafetyNetApplication;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.SafetyNetModel;

@RestController
public class ControllersMedicalRecord {
		
		@PostMapping("/medicalRecord")
		public SafetyNetModel addMedicalRecord(@RequestBody Medicalrecords medicalRecord) {
			 
		SafetyNetModel safetyModel = SafetyNetApplication.model;
		safetyModel.getMedicalrecords().add(medicalRecord);

		return safetyModel;
		}
		
		
		@PutMapping("/medicalRecord")
		public SafetyNetModel updateMedicalRecord(@RequestBody Medicalrecords medicalRecord) {
			SafetyNetModel safetyModel = SafetyNetApplication.model;
			String firstname = medicalRecord.getFirstName();
			String lastName = medicalRecord.getLastName();
			
			List<Medicalrecords> listMedicalRecord = safetyModel.getMedicalrecords();
			
			 for (Medicalrecords medi : listMedicalRecord) {
		            if(medi.getFirstName().equals(firstname) && medi.getLastName().equals(lastName)) {
		            	medi.setBirthdate(medicalRecord.getBirthdate());
		            	medi.setMedications(medicalRecord.getMedications());
		            	medi.setAllergies(medicalRecord.getAllergies());
		            	
		            }
		        }

		    return safetyModel;
		}
		
		@DeleteMapping("/medicalRecord")
		public SafetyNetModel deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {
			//http://localhost:8080/medicalRecord?firstName=John&lastName=Boyd
			SafetyNetModel safetyModel = SafetyNetApplication.model;
			
			List<Medicalrecords> listMedicalRecord = safetyModel.getMedicalrecords();

			int i=0;
			int j=0;
			 for (Medicalrecords medi : listMedicalRecord) {		 
		            if(medi.getFirstName().equals(firstName) && medi.getLastName().equals(lastName)) {
		            	i=j;
		            }
		            i++;
		        }
			 
			listMedicalRecord.remove(j);
 			safetyModel.setMedicalrecords(listMedicalRecord);

		    return safetyModel;
		}
		
		
}
