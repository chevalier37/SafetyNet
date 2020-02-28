package com.safetynet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class AlertBusiness {

	private AlertBusiness() {
	}

	private static final Logger logger = LogManager.getRootLogger();

	public static List<Enfant> childAlert(List<Person> listPersons, List<Medicalrecord> listMedicalRecords,
			String address) throws ParseException {
		List<Enfant> listChild = new ArrayList<>();
		List<Person> listpersonAdrress = new ArrayList<>();

		for (Person person : listPersons) {
			if (person.getAddress().equals(address)) {
				listpersonAdrress.add(person);
				for (Medicalrecord medical : listMedicalRecords) {
					if (person.getFirstName().equals(medical.getFirstName())
							&& person.getLastName().equals(medical.getLastName())
							&& !Age.isAdult(medical.getBirthdate())) {
						String firstName = medical.getFirstName();
						String LastName = medical.getLastName();
						int age = Age.calculAge(medical.getBirthdate());
						Enfant enfant = new Enfant(firstName, LastName, age, listpersonAdrress);
						listChild.add(enfant);
					}
				}
			}
		}
		logger.debug("listChild = {}", listChild);
		return listChild;
	}

	public static List<String> phoneAlert(List<Firestation> listFirestations, List<Person> listPersons,
			String firestation) {
		List<String> listphoneNumber = new ArrayList<>();

		for (Firestation fire : listFirestations) {
			if (fire.getStation().equals(firestation)) {
				for (Person person : listPersons) {
					if (person.getAddress().equals(fire.getAddress())) {
						listphoneNumber.add(person.getPhone());

					}
				}
			}
		}
		logger.debug("listphoneNumber = {}", listphoneNumber);
		return listphoneNumber;
	}

}
