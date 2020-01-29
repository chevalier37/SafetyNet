package com.SafetyNet.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SafetyNet.SafetyNetApplication;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;
import com.SafetyNet.models.SafetyNetModel;

@RestController
public class ControllersURLS {
	
	@GetMapping("/firestation")
	public List<Persons> stationNumber(@RequestParam String stationNumber) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<Firestations> listStationNumber = new ArrayList<Firestations>();
		
		 for (Firestations fire : listFirestations) {
	            if(fire.getStation().equals(stationNumber)) {
	            		listStationNumber.add(fire);
	            }
	        }
		 
		 List<Persons> listPersons = safetyModel.getPersons();
		 List<Persons> listPersonStations = new ArrayList<Persons>();
		 
		 for (Persons person : listPersons) {
			 for (Firestations station : listStationNumber) {
		            if(person.getAddress().equals(station.getAddress())) {
		            	listPersonStations.add(person);
		            }
		        }
	        }
		 
		 List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();

		 Calendar today = Calendar.getInstance();
		 Calendar birthDay = Calendar.getInstance();
		 int maj = 0;
		 
		 for (Persons personStation : listPersonStations) {
			 for (Medicalrecords medical : listMedicalRecords) {
		            if(personStation.getFirstName().equals(medical.getFirstName()) && personStation.getLastName().equals(medical.getLastName())) {
		            	
		            	Date birth = new SimpleDateFormat("MM/dd/yyyy").parse(medical.getBirthdate()); 
		            	birthDay.setTime(birth);
		            	int yearDiff = today.get(Calendar.YEAR)-birthDay.get(Calendar.YEAR);
		            	int monthDiff = today.MONTH - birthDay.MONTH;
		            	int dayDiff = today.DAY_OF_MONTH - birthDay.DAY_OF_MONTH;
		            	
		            	if(yearDiff >18 || yearDiff == 18 && monthDiff>=0 || yearDiff == 18 && monthDiff == 0 && dayDiff >=0) {
		            		maj++;
		            	}		            	
		            }
		        }
	        }
		 
		 int min = listPersonStations.size() - maj;
		 
		 System.out.println("adultes : " + maj + " enfants :" + min);

	    return listPersonStations;
	}
}
