package com.SafetyNet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;

public class ListHabitant {

	private ListHabitant() {
	}

	private static final Logger logger = LogManager.getRootLogger();

	public static List<Habitant> listHabitant(List<Persons> listPersons, List<Medicalrecords> listMedicalRecords,
			List<Firestations> listFirestations, String address) throws ParseException {
		List<Habitant> listHabitants = new ArrayList<>();

		for (Persons person : listPersons) {
			if (person.getAddress().equals(address)) {
				for (Medicalrecords medical : listMedicalRecords) {
					if (person.getFirstName().equals(medical.getFirstName())
							&& person.getLastName().equals(medical.getLastName())) {
						for (Firestations fire : listFirestations) {
							String firstName = person.getFirstName();
							String lastName = person.getLastName();
							String phone = person.getPhone();
							int age = Age.calculAge(medical.getBirthdate());
							String[] medications = medical.getMedications();
							String[] allergie = medical.getAllergies();
							String station = fire.getStation();

							if (fire.getAddress().equals(address)) {
								Habitant habitant = new Habitant(firstName, lastName, phone, age, medications, allergie,
										station, address);
								listHabitants.add(habitant);
							}
						}
					}
				}
			}
		}
		logger.debug("listHabitants = {}", listHabitants);
		return listHabitants;
	}

	public static List<Habitant> listHabitantStation(List<Persons> listPersons, List<Medicalrecords> listMedicalRecords,
			List<Firestations> listFirestations, String stations) throws ParseException {
		List<Habitant> listHabitants = new ArrayList<>();

		for (Firestations fire : listFirestations) {
			if (fire.getStation().equals(stations)) {
				for (Persons person : listPersons) {
					if (person.getAddress().equals(fire.getAddress())) {
						for (Medicalrecords medical : listMedicalRecords) {

							if (person.getFirstName().equals(medical.getFirstName())
									&& person.getLastName().equals(medical.getLastName())) {
								String firstName = person.getFirstName();
								String lastName = person.getLastName();
								String phone = person.getPhone();
								int age = Age.calculAge(medical.getBirthdate());
								String[] medications = medical.getMedications();
								String[] allergie = medical.getAllergies();
								String station = fire.getStation();
								String address = fire.getAddress();
								Habitant habitants = new Habitant(firstName, lastName, phone, age, medications,
										allergie, station, address);
								listHabitants.add(habitants);
							}
						}
					}
				}
			}
		}

		List<Habitant> listFoyer = new ArrayList<>();

		for (int i = 0; i < listHabitants.size(); i++) {
			for (int j = 0; j < listHabitants.size(); j++) {
				if (listHabitants.get(i).getAddress().equals(listHabitants.get(j).getAddress())) {

					if (!listFoyer.contains(listHabitants.get(i)))
						listFoyer.add(listHabitants.get(i));
				}
			}
		}
		logger.debug("listFoyer = {}", listFoyer);
		return listFoyer;
	}

}
