package com.safetynet.model;

import java.util.List;

public class SafetyNetModel {

	private List<Person> persons;

	private List<Firestation> firestations;

	private List<Medicalrecord> medicalrecords;

	public SafetyNetModel() {
	}

	public SafetyNetModel(List<Person> persons, List<Firestation> firestations, List<Medicalrecord> medicalrecords) {
		this.persons = persons;
		this.firestations = firestations;
		this.medicalrecords = medicalrecords;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public List<Medicalrecord> getMedicalrecords() {
		return medicalrecords;
	}

	public List<Firestation> getFirestations() {
		return firestations;
	}

	@Override
	public String toString() {
		return "SafetyNetModel [persons=" + persons + ", medicalrecord=" + medicalrecords + ", firestations="
				+ firestations + "]";
	}

}
