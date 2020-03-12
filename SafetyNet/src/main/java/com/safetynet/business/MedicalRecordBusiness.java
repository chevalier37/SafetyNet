package com.safetynet.business;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class MedicalRecordBusiness {

	public static Medicalrecord updateMedicalRecordBusiness(Map<?, ?> medicalRecord, String firstName, String lastName,
			LocalDate bithDate, List<String> medications, List<String> allergies, List<Person> persons) {

		Medicalrecord medicalrecord = new Medicalrecord(bithDate, medications, allergies);

		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				person.setMedicalRecord(medicalrecord);
			}
		}
		return medicalrecord;
	}

}
