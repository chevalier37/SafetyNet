package com.safetynet.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.safetynet.model.Medicalrecord;

public class ListTesting {

	private ListTesting() {
	}

	public static List<ModelPersonTest> listPersonTest() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/1990";
		String date3 = "01/01/2010";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);
		LocalDate birthdate3 = LocalDate.parse(date3, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();
		List<String> medication3 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		medication3.add("medication6");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();
		List<String> allergie3 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		allergie3.add("allergie6");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);
		Medicalrecord Medicalrecords3 = new Medicalrecord(birthdate3, medication3, allergie3);

		ModelPersonTest person1 = new ModelPersonTest("John1", "Boyd1", "1509 Culver St", "Culver", "97451",
				"841-874-6512", "jaboyd1@email.com", Medicalrecords1);
		ModelPersonTest person2 = new ModelPersonTest("John2", "Boyd2", "1509 Culver St", "Culver", "97451",
				"999-874-6512", "jaboyd2@email.com", Medicalrecords2);
		ModelPersonTest person3 = new ModelPersonTest("John3", "Boyd3", "900 Culver St", "Culver", "97451",
				"888-874-6512", "jaboyd3@email.com", Medicalrecords3);

		List<ModelPersonTest> listPersonTest = new ArrayList<>();
		listPersonTest.add(person1);
		listPersonTest.add(person2);
		listPersonTest.add(person3);

		return listPersonTest;
	}

	public static List<ModelFirestationTest> listFirestationTest() {

		Set<String> address1 = new HashSet<>();
		Set<String> address2 = new HashSet<>();

		address1.add("1509 Culver St");
		address2.add("900 Culver St");

		ModelFirestationTest fireStation1 = new ModelFirestationTest(1, address1);
		ModelFirestationTest fireStation2 = new ModelFirestationTest(2, address2);

		List<ModelFirestationTest> listFirestationsTest = new ArrayList<>();
		listFirestationsTest.add(fireStation1);
		listFirestationsTest.add(fireStation2);

		return listFirestationsTest;
	}

	public static List<Medicalrecord> listMedicalRecordTest() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/1990";
		String date3 = "01/01/2010";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);
		LocalDate birthdate3 = LocalDate.parse(date3, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();
		List<String> medication3 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		medication3.add("medication6");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();
		List<String> allergie3 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		allergie3.add("allergie6");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);
		Medicalrecord Medicalrecords3 = new Medicalrecord(birthdate3, medication3, allergie3);

		List<Medicalrecord> listMedicalrecordsTest = new ArrayList<>();
		listMedicalrecordsTest.add(Medicalrecords1);
		listMedicalrecordsTest.add(Medicalrecords2);
		listMedicalrecordsTest.add(Medicalrecords3);

		return listMedicalrecordsTest;
	}

	public static Map<Integer, ModelFirestationTest> MapFirestationTest() {
		Set<String> address1 = new HashSet<>();
		Set<String> address2 = new HashSet<>();

		address1.add("1509 Culver St");
		address2.add("900 Culver St");

		ModelFirestationTest fireStation1 = new ModelFirestationTest(1, address1);
		ModelFirestationTest fireStation2 = new ModelFirestationTest(2, address2);

		Map<Integer, ModelFirestationTest> mapFirestation = new HashMap<Integer, ModelFirestationTest>();

		mapFirestation.put(1, fireStation1);
		mapFirestation.put(2, fireStation2);

		return mapFirestation;

	}

	public static Map<String, List<ModelPersonTest>> FoyersTest() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/1990";
		String date3 = "01/01/2010";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);
		LocalDate birthdate3 = LocalDate.parse(date3, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();
		List<String> medication3 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		medication3.add("medication6");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();
		List<String> allergie3 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		allergie3.add("allergie6");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);
		Medicalrecord Medicalrecords3 = new Medicalrecord(birthdate3, medication3, allergie3);

		ModelPersonTest person1 = new ModelPersonTest("John1", "Boyd1", "1509 Culver St", "Culver", "97451",
				"841-874-6512", "jaboyd1@email.com", Medicalrecords1);
		ModelPersonTest person2 = new ModelPersonTest("John2", "Boyd2", "1509 Culver St", "Culver", "97451",
				"999-874-6512", "jaboyd2@email.com", Medicalrecords2);
		ModelPersonTest person3 = new ModelPersonTest("John3", "Boyd3", "900 Culver St", "Culver", "97451",
				"888-874-6512", "jaboyd3@email.com", Medicalrecords3);

		List<ModelPersonTest> listPersonTest1 = new ArrayList<>();
		List<ModelPersonTest> listPersonTest2 = new ArrayList<>();
		listPersonTest1.add(person1);
		listPersonTest1.add(person2);
		listPersonTest2.add(person3);

		Map<String, List<ModelPersonTest>> mapFoyers = new HashMap<String, List<ModelPersonTest>>();
		mapFoyers.put("1509 Culver St", listPersonTest1);
		mapFoyers.put("900 Culver St", listPersonTest2);

		return mapFoyers;

	}

}
