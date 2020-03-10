package com.safetynet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.business.Age;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

@SpringBootTest
public class AgeTest {

	List<Person> listPersonsTest = ListTesting.listPersonTest();
	List<Firestation> listFirestationsTest = ListTesting.listFirestationTest();
	List<Medicalrecord> listMedicalrecordsTest = ListTesting.listMedicalRecordTest();

	@Test
	@DisplayName("is majeur")
	public void isMajeurTest() throws ParseException {
		boolean isMajeur = Age.isAdult("01/01/2000");
		assertEquals(true, isMajeur);
	}

}
