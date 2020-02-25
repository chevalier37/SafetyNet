package com.SafetyNet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.SafetyNet.business.FirestationBusiness;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

@SpringBootTest
public class FirestationBusinessTest {

	List<Persons> listPersonsTest = ListTesting.listPersonTest();
	List<Firestations> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecords> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();

	@Test
	@DisplayName("Firestation test")
	public void listPersonStationsTest() {

		Persons person1 = new Persons("John3", "Boyd3", "900 Culver St", "Culver", "97451", "888-874-6512",
				"jaboyd3@email.com");
		List<Persons> listPersonStationsExpected = new ArrayList<Persons>();
		listPersonStationsExpected.add(person1);

		List<Persons> listPersonStations = FirestationBusiness.listPersonStations(listPersonsTest, listFirestationsTest,
				"2");

		assertEquals(listPersonStationsExpected.get(0).getFirstName(), listPersonStations.get(0).getFirstName());
	}
}
