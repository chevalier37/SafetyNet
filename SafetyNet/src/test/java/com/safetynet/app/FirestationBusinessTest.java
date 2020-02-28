package com.safetynet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.business.FirestationBusiness;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

@SpringBootTest
public class FirestationBusinessTest {

	List<Person> listPersonsTest = ListTesting.listPersonTest();
	List<Firestation> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecord> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();

	@Test
	@DisplayName("Firestation test")
	public void listPersonStationsTest() {

		Person person1 = new Person("John3", "Boyd3", "900 Culver St", "Culver", "97451", "888-874-6512",
				"jaboyd3@email.com");
		List<Person> listPersonStationsExpected = new ArrayList<Person>();
		listPersonStationsExpected.add(person1);

		List<Person> listPersonStations = FirestationBusiness.listPersonStations(listPersonsTest, listFirestationsTest,
				"2");

		assertEquals(listPersonStationsExpected.get(0).getFirstName(), listPersonStations.get(0).getFirstName());
	}
}
