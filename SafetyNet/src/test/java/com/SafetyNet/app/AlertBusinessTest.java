package com.SafetyNet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.SafetyNet.business.AlertBusiness;
import com.SafetyNet.business.Enfants;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

@SpringBootTest
public class AlertBusinessTest {

	List<Persons> listPersonsTest = ListTesting.listPersonTest();
	List<Firestations> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecords> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();
	String address = "900 Culver St";

	@Test
	@DisplayName("Alert Child Test")
	public void childAlertTest() throws ParseException {

		Persons person3 = new Persons("John3", "Boyd3", "900 Culver St", "Culver", "97451", "888-874-6512",
				"jaboyd3@email.com");
		List<Persons> membreFoyer = new ArrayList<Persons>();
		membreFoyer.add(person3);

		Enfants child1 = new Enfants("John3", "Boyd3", 10, membreFoyer);
		List<Enfants> listChildExpected = new ArrayList<Enfants>();
		listChildExpected.add(child1);

		List<Enfants> listChild = AlertBusiness.childAlert(listPersonsTest, listMedicalrecordsTest, address);

		assertEquals(listChildExpected.get(0).getFirstName(), listChild.get(0).getFirstName());
	}

	@Test
	@DisplayName("Phone alert Test")
	public void phoneAlertTest() throws ParseException {

		List<String> listPhoneExpected = new ArrayList<>();
		listPhoneExpected.add("841-874-6512");
		listPhoneExpected.add("999-874-6512");

		List<String> listPhone = AlertBusiness.phoneAlert(listFirestationsTest, listPersonsTest, "1");

		assertEquals(listPhoneExpected, listPhone);
	}

}
