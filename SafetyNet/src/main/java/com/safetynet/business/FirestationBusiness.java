package com.safetynet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;

public class FirestationBusiness {

	public static Map<Integer, Firestation> updateFirestationBusiness(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations) {

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
			if (fire.getStation() == stationNumber) {
				fire.addAddress(stationAdress);
			}
		}
		return getfirestations;
	}

	public static Map<Integer, Firestation> deleteFirestationBusiness(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations) {

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
		}
		return getfirestations;
	}

	public static ListPersonStation stationNumberBusiness(String stationNumber,
			Map<Integer, Firestation> getfirestations, List<Person> listSafetyPerson) throws ParseException {

		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(Integer.parseInt(stationNumber));

			if (fire.getStation() == Integer.parseInt(stationNumber)) {
				addresses = fire.getAddresses();
			}
		}

		for (Person person : listSafetyPerson) {
			if (addresses.contains(person.getAddress())) {
				listPersonResult.add(person);
			}
		}

		int nbrAdult = 0;
		for (Person person : listPersonResult) {
			if (Age.isAdult(person.getMedicalRecord().getBirthdate())) {
				nbrAdult++;
			}
		}

		int nbrChild = listPersonResult.size() - nbrAdult;

		ListPersonStation listpersonStation = new ListPersonStation(listPersonResult, nbrAdult, nbrChild);

		return listpersonStation;

	}

	public static List<Habitant> fireBusiness(String address, List<Person> listPerson,
			Map<Integer, Firestation> getfirestations) throws ParseException {

		List<Habitant> listHabitant = new ArrayList<Habitant>();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);

			if (fire.getAddresses().contains(address)) {
				int stationNum = fire.getStation();
				for (Person person : listPerson) {
					if (person.getAddress().equals(address)) {
						int age = Age.calculAge(person.getMedicalRecord().getBirthdate());
						Habitant habitant = new Habitant(age, person, stationNum);
						listHabitant.add(habitant);
					}
				}
			}
		}

		return listHabitant;
	}

	public static List<Person> floodBusiness(String stations, Map<Integer, Firestation> getfirestations,
			Map<String, List<Person>> getFoyers) throws ParseException {

		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(Integer.parseInt(stations));

			if (fire.getStation() == Integer.parseInt(stations)) {
				addresses = fire.getAddresses();
			}
		}

		Set key = getFoyers.keySet();
		Iterator iter = key.iterator();
		while (iter.hasNext()) {
			Object num = iter.next();
			List<Person> persons = getFoyers.get(num);

			for (Person person : persons) {
				if (addresses.contains(person.getAddress())) {
					listPersonResult.add(person);
				}
			}
		}

		return listPersonResult;
	}

}
