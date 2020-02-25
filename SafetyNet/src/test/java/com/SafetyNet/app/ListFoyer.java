package com.SafetyNet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.SafetyNet.business.ListPersonInfo;
import com.SafetyNet.business.PersonInfo;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

@SpringBootTest
public class ListFoyer {

	List<Persons> listPersonsTest = ListTesting.listPersonTest();
	List<Firestations> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecords> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();

	@Test
	@DisplayName("List foyer Test")
	public void ListFoyerTest() throws ParseException {

		String[] medications = { "medoc1", "medoc2", "medoc3" };
		String[] allergies = { "allergie1", "allergie2" };

		PersonInfo person1 = new PersonInfo("John3", "Boyd3", "900 Culver St", "jaboyd3@email.com", 10, medications,
				allergies);
		List<PersonInfo> listPersoninfoExpected = new ArrayList<PersonInfo>();
		listPersoninfoExpected.add(person1);

		List<PersonInfo> listPersoninfo = ListPersonInfo.listPersoninfo(listPersonsTest, listMedicalrecordsTest,
				"John3", "Boyd3");

		assertEquals(listPersoninfoExpected.get(0).getFirstName(), listPersoninfo.get(0).getFirstName());
	}

	@Test
	@DisplayName("List email Test")
	public void ListEmailTest() throws ParseException {

		String email1 = "jaboyd1@email.com";
		String email2 = "jaboyd2@email.com";
		String email3 = "jaboyd3@email.com";

		List<String> listEmailExpected = new ArrayList<String>();
		listEmailExpected.add(email1);
		listEmailExpected.add(email2);
		listEmailExpected.add(email3);

		List<String> listEmail = ListPersonInfo.listEmail(listPersonsTest, "Culver");

		assertEquals(listEmailExpected, listEmail);
	}

}
