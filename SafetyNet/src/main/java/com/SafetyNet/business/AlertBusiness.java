package com.SafetyNet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

public class AlertBusiness {

	private static final Logger logger = LogManager.getRootLogger();

	public static List<Enfants> childAlert(List<Persons> listPersons, List<Medicalrecords> listMedicalRecords,
			String address) throws ParseException {
		List<Enfants> listChild = new ArrayList<Enfants>();
		List<Persons> listpersonAdrress = new ArrayList<Persons>();

		for (Persons person : listPersons) {
			if (person.getAddress().equals(address)) {
				listpersonAdrress.add(person);
				for (Medicalrecords medical : listMedicalRecords) {
					if (person.getFirstName().equals(medical.getFirstName())
							&& person.getLastName().equals(medical.getLastName())
							&& !Age.isAdult(medical.getBirthdate())) {
						String firstName = medical.getFirstName();
						String LastName = medical.getLastName();
						int age = Age.calculAge(medical.getBirthdate());
						Enfants enfant = new Enfants(firstName, LastName, age, listpersonAdrress);
						listChild.add(enfant);
					}
				}
			}
		}
		logger.debug("listChild = " + listChild);
		return listChild;
	}

	public static List<String> phoneAlert(List<Firestations> listFirestations, List<Persons> listPersons,
			String firestation) {
		List<String> listphoneNumber = new ArrayList<String>();

		for (Firestations fire : listFirestations) {
			if (fire.getStation().equals(firestation)) {
				for (Persons person : listPersons) {
					if (person.getAddress().equals(fire.getAddress())) {
						listphoneNumber.add(person.getPhone());

					}
				}
			}
		}
		logger.debug("listphoneNumber = " + listphoneNumber);
		return listphoneNumber;
	}

}
