package com.safetynet.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;

public class FirestationBusiness {

	private FirestationBusiness() {
	}

	private static final Logger logger = LogManager.getRootLogger();

	public static List<Person> listPersonStations(List<Person> listPersons, List<Firestation> listFirestation,
			String stationNumber) {

		List<Person> listPersonStations = new ArrayList<>();

		List<Firestation> listStationNumber = new ArrayList<>();

		for (Firestation fire : listFirestation) {
			if (fire.getStation().equals(stationNumber)) {
				listStationNumber.add(fire);
				for (Person person : listPersons) {
					for (Firestation station : listStationNumber) {
						if (person.getAddress().equals(station.getAddress())) {
							listPersonStations.add(person);
						}
					}
				}
			}
		}
		logger.debug("listPersonStations = {}", listPersonStations);
		return listPersonStations;
	}

}
