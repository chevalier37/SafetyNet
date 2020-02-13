package com.SafetyNet.app;

import java.util.ArrayList;
import java.util.List;

import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

public class ListTest {

	public static List<Persons> listPersonTest() {

		Persons person1 = new Persons("John1", "Boyd1", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd1@email.com");
		Persons person2 = new Persons("John2", "Boyd2", "1509 Culver St", "Culver", "97451", "999-874-6512",
				"jaboyd2@email.com");
		Persons person3 = new Persons("John3", "Boyd3", "900 Culver St", "Culver", "97451", "888-874-6512",
				"jaboyd3@email.com");

		List<Persons> listPersonTest = new ArrayList<Persons>();
		listPersonTest.add(person1);
		listPersonTest.add(person2);
		listPersonTest.add(person3);

		return listPersonTest;
	}

	public static List<Firestations> listFirestationTest() {

		Firestations fireStation1 = new Firestations("1509 Culver St", "1");
		Firestations fireStation2 = new Firestations("900 Culver St", "2");

		List<Firestations> listFirestationsTest = new ArrayList<Firestations>();
		listFirestationsTest.add(fireStation1);
		listFirestationsTest.add(fireStation2);

		return listFirestationsTest;
	}

	public static List<Medicalrecords> listMedicalRecordTest() {

		String[] medications = { "medoc1", "medoc2", "medoc3" };
		String[] allergies = { "allergie1", "allergie2" };

		Medicalrecords Medicalrecords1 = new Medicalrecords("John1", "Boyd1", "03/06/1984", medications, allergies);
		Medicalrecords Medicalrecords2 = new Medicalrecords("John2", "Boyd2", "03/06/1990", medications, allergies);
		Medicalrecords Medicalrecords3 = new Medicalrecords("John3", "Boyd3", "01/01/2010", medications, allergies);

		List<Medicalrecords> listMedicalrecordsTest = new ArrayList<Medicalrecords>();
		listMedicalrecordsTest.add(Medicalrecords1);
		listMedicalrecordsTest.add(Medicalrecords2);
		listMedicalrecordsTest.add(Medicalrecords3);

		return listMedicalrecordsTest;
	}

}
