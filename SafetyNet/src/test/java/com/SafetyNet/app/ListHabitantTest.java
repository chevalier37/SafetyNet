package com.SafetyNet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.SafetyNet.business.Habitant;
import com.SafetyNet.business.ListHabitant;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

@SpringBootTest
public class ListHabitantTest {

	List<Persons> listPersonsTest = ListTesting.listPersonTest();
	List<Firestations> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecords> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();
	String address = "900 Culver St";

	@Test
	@DisplayName("List habitant Station  Test")
	public void listHabitantStationTest() throws ParseException {

		String[] medications = { "medoc1", "medoc2", "medoc3" };
		String[] allergies = { "allergie1", "allergie2" };

		Habitant person1 = new Habitant("John3", "Boyd3", "888-874-6512", 10, medications, allergies, "2",
				"900 Culver St");
		List<Habitant> listPersonTest = new ArrayList<Habitant>();
		listPersonTest.add(person1);

		List<Habitant> listHabitantExpected = listPersonTest;

		List<Habitant> listHabitant = ListHabitant.listHabitantStation(listPersonsTest, listMedicalrecordsTest,
				listFirestationsTest, "2");

		assertEquals(listHabitantExpected.get(0).getFirstName(), listHabitant.get(0).getFirstName());
	}

	@Test
	@DisplayName("List habitant Test")
	public void listHabitantTest() throws ParseException {

		String[] medications = { "medoc1", "medoc2", "medoc3" };
		String[] allergies = { "allergie1", "allergie2" };

		Habitant person1 = new Habitant("John3", "Boyd3", "888-874-6512", 10, medications, allergies, "2",
				"900 Culver St");
		List<Habitant> listPersonTest = new ArrayList<Habitant>();
		listPersonTest.add(person1);

		List<Habitant> listHabitantExpected = listPersonTest;

		List<Habitant> listHabitant = ListHabitant.listHabitant(listPersonsTest, listMedicalrecordsTest,
				listFirestationsTest, address);

		assertEquals(listHabitantExpected.get(0).getFirstName(), listHabitant.get(0).getFirstName());
	}

}
