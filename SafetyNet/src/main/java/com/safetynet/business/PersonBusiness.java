package com.safetynet.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;

public class PersonBusiness {

	public static List<Person> updatePersonBusiness(List<Person> listPersons, Person persons, String firstname,
			String lastName) {

		for (Person pers : listPersons) {
			if (pers.getFirstName().equals(firstname) && pers.getLastName().equals(lastName)) {
				pers.setAddress(persons.getAddress());
				pers.setCity(persons.getCity());
				pers.setZip(persons.getZip());
				pers.setPhone(persons.getPhone());
				pers.setEmail(persons.getEmail());
			}
		}

		return listPersons;
	}

	public static List<Person> deletePersonBusiness(String firstName, String lastName, List<Person> listPersons) {
		int i = 0;
		int j = 0;
		for (Person pers : listPersons) {
			if (pers.getFirstName().equals(firstName) && pers.getLastName().equals(lastName)) {
				i = j;
			}
			i++;
		}
		listPersons.remove(j);
		return listPersons;
	}

	public static List<Enfant> getChildList(Map<String, List<Person>> foyers, List<Enfant> childlist,
			String address) throws ParseException {
		foyers.entrySet();
		for (Entry<String, List<Person>> entry : foyers.entrySet()) {
			String foyerAddress = entry.getKey();
			if (!address.equals(foyerAddress)) {
				continue;
			}
			List<Person> listFoyers = entry.getValue();
			for (Person person : listFoyers) {
				if (!Age.isAdult(person.getMedicalRecord().getBirthdate())) {
					int age = Age.calculAge(person.getMedicalRecord().getBirthdate());
					Enfant child = new Enfant(age, person, listFoyers);
					childlist.add(child);
				}
			}
		}
		return childlist;
	}

	public static List<String> phoneAlertBusiness(String firestation, Map<Integer, Firestation> getfirestations,
			List<Person> listSafetyPerson) {

		List<String> listPhoneNumber = new ArrayList<String>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(Integer.parseInt(firestation));

			if (fire.getStation() == Integer.parseInt(firestation)) {
				addresses = fire.getAddresses();
			}
		}

		for (Person person : listSafetyPerson) {
			if (addresses.contains(person.getAddress())) {
				listPhoneNumber.add(person.getPhone());
			}
		}
		return listPhoneNumber;
	}

	public static List<PersonInfo> personInfoBusiness(String firstName, String lastName, List<Person> listPerson)
			throws ParseException {

		List<PersonInfo> listPersonResult = new ArrayList<PersonInfo>();

		for (Person person : listPerson) {
			if (person.getLastName().equals(lastName)) {
				int age = Age.calculAge(person.getMedicalRecord().getBirthdate());
				PersonInfo peronInfo = new PersonInfo(person.getFirstName(), person.getLastName(), age,
						person.getAddress(), person.getCity(), person.getZip(), person.getPhone(), person.getEmail(),
						person.getMedicalRecord());
				listPersonResult.add(peronInfo);
			}
		}
		return listPersonResult;
	}

	public static List<String> communityEmail(String city, List<Person> listSafetyPerson) {

		List<String> listEmail = new ArrayList<String>();

		for (Person person : listSafetyPerson) {
			listEmail.add(person.getEmail());
		}
		return listEmail;
	}

}
