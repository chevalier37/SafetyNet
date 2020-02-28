package com.safetynet.app;

import java.util.ArrayList;
import java.util.List;

import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class ListTesting {

	private ListTesting() {
	}

	public static List<Person> listPersonTest() {

		Person person1 = new Person("John1", "Boyd1", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd1@email.com");
		Person person2 = new Person("John2", "Boyd2", "1509 Culver St", "Culver", "97451", "999-874-6512",
				"jaboyd2@email.com");
		Person person3 = new Person("John3", "Boyd3", "900 Culver St", "Culver", "97451", "888-874-6512",
				"jaboyd3@email.com");

		List<Person> listPersonTest = new ArrayList<>();
		listPersonTest.add(person1);
		listPersonTest.add(person2);
		listPersonTest.add(person3);

		return listPersonTest;
	}

	public static List<Firestation> listFirestationTest() {

		Firestation fireStation1 = new Firestation("1509 Culver St", "1");
		Firestation fireStation2 = new Firestation("900 Culver St", "2");

		List<Firestation> listFirestationsTest = new ArrayList<>();
		listFirestationsTest.add(fireStation1);
		listFirestationsTest.add(fireStation2);

		return listFirestationsTest;
	}

	public static List<Medicalrecord> listMedicalRecordTest() {

		String[] medications = { "medoc1", "medoc2", "medoc3" };
		String[] allergies = { "allergie1", "allergie2" };

		Medicalrecord Medicalrecords1 = new Medicalrecord("John1", "Boyd1", "03/06/1984", medications, allergies);
		Medicalrecord Medicalrecords2 = new Medicalrecord("John2", "Boyd2", "03/06/1990", medications, allergies);
		Medicalrecord Medicalrecords3 = new Medicalrecord("John3", "Boyd3", "01/01/2010", medications, allergies);

		List<Medicalrecord> listMedicalrecordsTest = new ArrayList<>();
		listMedicalrecordsTest.add(Medicalrecords1);
		listMedicalrecordsTest.add(Medicalrecords2);
		listMedicalrecordsTest.add(Medicalrecords3);

		return listMedicalrecordsTest;
	}

}
