package com.SafetyNet.models;

import java.util.List;


public class SafetyNetModel {
	
	
	private List<Persons> persons;
	
	private List<Firestations> firestations;
	
	private List<Medicalrecords> medicalrecords;
	
	public SafetyNetModel() {
	}
	
	public SafetyNetModel(List<Persons> persons, List<Firestations> firestations, List<Medicalrecords> medicalrecords) {
		this.persons = persons;
		this.firestations = firestations;
		this.medicalrecords = medicalrecords;
	}

	public List<Persons> getPersons() {
		return persons;
	}

	public void setPersons(List<Persons> persons) {
		this.persons = persons;
	}

	public List<Medicalrecords> getMedicalrecords() {
		return medicalrecords;
	}

	public void setMedicalrecords(List<Medicalrecords> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}

	public List<Firestations> getFirestations() {
		return firestations;
	}

	public void setFirestations(List<Firestations> firestations) {
		this.firestations = firestations;
	}

	@Override
	public String toString() {
		return "SafetyNetModel [persons=" + persons + ", medicalrecord=" + medicalrecords + ", firestations=" + firestations
				+ "]";
	}
	
}
