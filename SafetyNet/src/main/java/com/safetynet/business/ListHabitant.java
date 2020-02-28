package com.safetynet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class ListHabitant {

	private ListHabitant() {
	}

	private static final Logger logger = LogManager.getRootLogger();

	public static List<Habitant> listHabitant(List<Person> listPersons, List<Medicalrecord> listMedicalRecords,
			List<Firestation> listFirestations, String address) throws ParseException {
		List<Habitant> listHabitants = new ArrayList<>();

		for (Person person : listPersons) {
			if (person.getAddress().equals(address)) {
				for (Medicalrecord medical : listMedicalRecords) {
					if (person.getFirstName().equals(medical.getFirstName())
							&& person.getLastName().equals(medical.getLastName())) {
						for (Firestation fire : listFirestations) {
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

	public static List<Habitant> listHabitantStation(List<Person> listPersons, List<Medicalrecord> listMedicalRecords,
			List<Firestation> listFirestations, String stations) throws ParseException {
		List<Habitant> listHabitants = new ArrayList<>();

		for (Firestation fire : listFirestations) {
			if (fire.getStation().equals(stations)) {
				for (Person person : listPersons) {
					if (person.getAddress().equals(fire.getAddress())) {
						for (Medicalrecord medical : listMedicalRecords) {

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
