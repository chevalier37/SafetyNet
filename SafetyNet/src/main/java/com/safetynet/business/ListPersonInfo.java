package com.safetynet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class ListPersonInfo {

	private ListPersonInfo() {
	}

	private static final Logger logger = LogManager.getRootLogger();

	public static List<PersonInfo> listPersoninfo(List<Person> listPersons, List<Medicalrecord> listMedicalRecords,
			String firstName, String lastName) throws ParseException {
		List<PersonInfo> listInfo = new ArrayList<>();

		for (Person person : listPersons) {
			if (person.getLastName().equals(lastName) && person.getFirstName().equals(firstName)) {
				for (Medicalrecord medical : listMedicalRecords) {
					if (medical.getLastName().equals(person.getLastName())) {
						String firstName1 = medical.getFirstName();
						String lastName1 = medical.getLastName();
						String address = person.getAddress();
						String mail = person.getEmail();
						int age = Age.calculAge(medical.getBirthdate());
						String[] medications = medical.getMedications();
						String[] allergie = medical.getAllergies();
						PersonInfo personInfo = new PersonInfo(firstName1, lastName1, address, mail, age, medications,
								allergie);
						listInfo.add(personInfo);

					}
				}
			}
		}
		logger.debug("listInfo = {}", listInfo);
		return listInfo;
	}

	public static List<String> listEmail(List<Person> listPersons, String city) {
		List<String> listEmail = new ArrayList<String>();

		for (Person person : listPersons) {
			if (person.getCity().equals(city)) {
				String mail = person.getEmail();
				listEmail.add(mail);
			}
		}
		logger.debug("listEmail = {}", listEmail);
		return listEmail;
	}
}
