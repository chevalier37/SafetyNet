package com.SafetyNet.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Persons;

public class FirestationBusiness {

	private static final Logger logger = LogManager.getRootLogger();

	public static List<Persons> listPersonStations(List<Persons> listPersons, List<Firestations> listFirestation,
			String stationNumber) {

		List<Persons> listPersonStations = new ArrayList<Persons>();

		List<Firestations> listStationNumber = new ArrayList<Firestations>();

		for (Firestations fire : listFirestation) {
			if (fire.getStation().equals(stationNumber)) {
				listStationNumber.add(fire);
				for (Persons person : listPersons) {
					for (Firestations station : listStationNumber) {
						if (person.getAddress().equals(station.getAddress())) {
							listPersonStations.add(person);
						}
					}
				}
			}
		}
		logger.debug("listPersonStations = " + listPersonStations);
		return listPersonStations;
	}

}
