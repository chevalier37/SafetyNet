package com.SafetyNet.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SafetyNet.SafetyNetApplication;
import com.SafetyNet.models.Enfants;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Foyers;
import com.SafetyNet.models.Habitants;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.PersonInfo;
import com.SafetyNet.models.Persons;
import com.SafetyNet.models.SafetyNetModel;
import com.SafetyNet.services.Age;

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

		 int nbAdultes = 0;
		 
		 for (Persons personStation : listPersonStations) {
			 for (Medicalrecords medical : listMedicalRecords) {
		            if(personStation.getFirstName().equals(medical.getFirstName()) && personStation.getLastName().equals(medical.getLastName())) {            	
		            	if(Age.majeur(medical.getBirthdate())) {
		            		nbAdultes++;
		            	}		            	
		            }
		        }
	        }
		 
		 int nbEnfant = listPersonStations.size() - nbAdultes;
		 
		 //A faire dans le retour Json -->créer class
		 System.out.println("adultes : " + nbAdultes + " enfants :" + nbEnfant);

	    return listPersonStations;
	}
	
	@GetMapping("/childAlert")
	public List<Enfants> childAlert(@RequestParam String address) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Persons> listPersons = safetyModel.getPersons();
		List<Enfants> listChild = new ArrayList<Enfants>();
		List<Persons> listpersonAdrress = new ArrayList<Persons>();
				 
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();
		 
		 for (Persons person : listPersons) {
			 if(person.getAddress().equals(address)) { 
				 listpersonAdrress.add(person);
			 for (Medicalrecords medical : listMedicalRecords) {            	
				 if(person.getFirstName().equals(medical.getFirstName()) 
						 && person.getLastName().equals(medical.getLastName()) 
						 && !Age.majeur(medical.getBirthdate())) {
					 String firstName =medical.getFirstName();
					 String LastName =medical.getLastName();
					 int age = Age.calculAge(medical.getBirthdate());
					 Enfants enfant = new Enfants(firstName, LastName, age, listpersonAdrress);
					 listChild.add(enfant);
					 
	            	}		            	
		           }
		       }
		 }
	    return listChild;
	}
	
	@GetMapping("/phoneAlert")
	public List<String> phoneAlert(@RequestParam String firestation)  {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Persons> listPersons = safetyModel.getPersons();
		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<String> listphoneNumber = new ArrayList<String>();
		 
		 for (Firestations fire : listFirestations) {
			 if(fire.getStation().equals(firestation)) {  
			 for (Persons person : listPersons) {            	
				 if(person.getAddress().equals(fire.getAddress())) {
					 listphoneNumber.add(person.getPhone());
					 
	            	}		            	
		           }
		       }
		 }
	    return listphoneNumber;
	}
	
	@GetMapping("/fire")
	public List<Habitants> fire(@RequestParam String address) throws ParseException  {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Persons> listPersons = safetyModel.getPersons();
		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<Habitants> listHabitants = new ArrayList<Habitants>();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();
		 
		 for (Persons person : listPersons) {
			 if(person.getAddress().equals(address)) {  
				 for (Medicalrecords medical : listMedicalRecords) {  
					 if(person.getFirstName().equals(medical.getFirstName()) && person.getLastName().equals(medical.getLastName())){
						 for (Firestations fire : listFirestations) { 
							 String firstName = person.getFirstName();
							 String lastName = person.getLastName();
							 String phone = person.getPhone();
							 int age = Age.calculAge(medical.getBirthdate());
							 String[] medications = medical.getMedications();
							 String[] allergie = medical.getAllergies();
							 String station = fire.getStation();
							 
							 if(fire.getAddress().equals(address)) {
								 Habitants habitant = new Habitants(firstName, lastName, phone, age, medications, allergie, station, address );
								 listHabitants.add(habitant);
							 }
						 }
					 }					 
				 }
		       }
		 }
	    return listHabitants;
	}
	
	@GetMapping("/flood/stations")
	public List<Foyers> flood(@RequestParam String stations) throws ParseException  {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Persons> listPersons = safetyModel.getPersons();
		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<Habitants> listHabitants = new ArrayList<Habitants>();
		List<Foyers> listfoyers = new ArrayList<Foyers>();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();
		 
		 for (Firestations fire : listFirestations) {
			 if(fire.getStation().equals(stations)) {  
				 for (Persons person : listPersons) {
					 if(person.getAddress().equals(fire.getAddress())){
						 for (Medicalrecords medical : listMedicalRecords) { 

							 if(person.getFirstName().equals(medical.getFirstName()) 
									 && person.getLastName().equals(medical.getLastName())) {
								 String firstName = person.getFirstName();
								 String lastName = person.getLastName();
								 String phone = person.getPhone();
								 int age = Age.calculAge(medical.getBirthdate());
								 String[] medications = medical.getMedications();
								 String[] allergie = medical.getAllergies();
								 String station = fire.getStation();
								 String address = fire.getAddress();		
								 Habitants habitants = new Habitants(firstName, lastName, phone, age, medications, allergie, station, address);
								 listHabitants.add(habitants);
								}
						 }												
					}
				}
			}					 					 
	   }

	
	Foyers foyer = new Foyers(stations, null, null);
	
		 for (int i=0;i<listHabitants.size();i++) {	
			 List<Habitants> listHabitantsFoyer = new ArrayList<Habitants>();
			 for (int j=0;j<listHabitants.size();j++) {		
				 
				 if(listHabitants.get(j).getAddress().equals(listHabitants.get(i).getAddress())){
					 
					 listHabitantsFoyer.add(listHabitants.get(i));
					 
				 }
				 j++;
			 }
			 foyer.setAddress(listHabitants.get(i).getAddress());
			 foyer.setHabitant(listHabitantsFoyer);
			 i++;
			 listfoyers.add(foyer);	
		 }
		 
	    return listfoyers;
	}
	
	@GetMapping("/personInfo")
	public List<PersonInfo> personInfo(@RequestParam String firstName, String lastName) throws ParseException  {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Persons> listPersons = safetyModel.getPersons();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();
		List<PersonInfo> listInfo = new ArrayList<PersonInfo>();
		 
		 for (Persons person : listPersons) {
			 if(person.getLastName().equals(lastName) && person.getFirstName().equals(firstName)) {  
				 for (Medicalrecords medical : listMedicalRecords) {  
					 if(medical.getLastName().equals(person.getLastName())){
						 String firstName1 = medical.getFirstName();
						 String lastName1 = medical.getLastName();
						 String address = person.getAddress();
						 String mail = person.getEmail();
						 int age = Age.calculAge(medical.getBirthdate());
						 String[] medications = medical.getMedications();
						 String[] allergie = medical.getAllergies();
						 PersonInfo personInfo = new PersonInfo(firstName1, lastName1, address, mail, age, medications, allergie);
							 listInfo.add(personInfo);
 
					 }					 
				 }
		       }
		 }
	    return listInfo;
	}
	
	@GetMapping("/communityEmail")
	public List<String> communityEmail(@RequestParam String city) throws ParseException  {
		SafetyNetModel safetyModel = SafetyNetApplication.model;
				
		List<Persons> listPersons = safetyModel.getPersons();
		List<String> listEmail = new ArrayList<String>();
		
		for (Persons person : listPersons) {
			 if(person.getCity().equals(city)) {  
						 String mail = person.getEmail();
						 listEmail.add(mail);
					 }					 
				 }

	    return listEmail;
	}
	
	
}
