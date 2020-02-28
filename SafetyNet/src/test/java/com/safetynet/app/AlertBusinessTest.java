package com.safetynet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.business.AlertBusiness;
import com.safetynet.business.Enfant;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

@SpringBootTest
public class AlertBusinessTest {

	List<Person> listPersonsTest = ListTesting.listPersonTest();
	List<Firestation> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecord> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();
	String address = "900 Culver St";

	@Test
	@DisplayName("Alert Child Test")
	public void childAlertTest() throws ParseException {

		Person person3 = new Person("John3", "Boyd3", "900 Culver St", "Culver", "97451", "888-874-6512",
				"jaboyd3@email.com");
		List<Person> membreFoyer = new ArrayList<Person>();
		membreFoyer.add(person3);

		Enfant child1 = new Enfant("John3", "Boyd3", 10, membreFoyer);
		List<Enfant> listChildExpected = new ArrayList<Enfant>();
		listChildExpected.add(child1);

		List<Enfant> listChild = AlertBusiness.childAlert(listPersonsTest, listMedicalrecordsTest, address);

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
