package com.safetynet.app;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.business.Age;
import com.safetynet.business.FirestationBusiness;
import com.safetynet.business.Habitant;
import com.safetynet.business.ListPersonStation;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

@SpringBootTest
public class FirestationBusinessTest {

	@Test
	@DisplayName("Update Firestation test")
	public void updateFirestationBusinessTest() {

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("1509 Culver St");
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Firestation firestation = new Firestation(1);
		firestation.addAddress("1509 Culver St");
		Map<Integer, Firestation> getfirestations = new HashMap<Integer, Firestation>();
		getfirestations.put(1, firestation);
		FirestationBusiness.updateFirestationBusiness(1, "15010 Culver St", getfirestations);

		assertEquals(getfirestations1.toString(), getfirestations.toString());
	}

	@Test
	@DisplayName("Delete Firestation test")
	public void deleteFirestationBusinessTest() {

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Firestation firestation = new Firestation(1);
		firestation.addAddress("1509 Culver St");
		firestation.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations = new HashMap<Integer, Firestation>();
		getfirestations.put(1, firestation);
		FirestationBusiness.deleteFirestationBusiness(1, "1509 Culver St", getfirestations);

		assertEquals(getfirestations1.toString(), getfirestations.toString());
	}

	@Test
	@DisplayName("Station number test")
	public void stationNumberBusinessTest() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(person1);
		listPerson.add(person2);

		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations1.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations1.get(Integer.parseInt("1"));

			if (fire.getStation() == Integer.parseInt("1")) {
				addresses = fire.getAddresses();
			}
		}

		for (Person person : listPerson) {
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

		ListPersonStation test = FirestationBusiness.stationNumberBusiness("1", getfirestations1, listPerson);

		assertEquals(listpersonStation.toString(), test.toString());
	}

	@Test
	@DisplayName("Fire test")
	public void fireBusinessTest() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(person1);
		listPerson.add(person2);

		List<Habitant> listHabitant = new ArrayList<Habitant>();

		Set cles = getfirestations1.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations1.get(station);

			if (fire.getAddresses().contains("15010 Culver St")) {
				int stationNum = fire.getStation();
				for (Person person : listPerson) {
					if (person.getAddress().equals("15010 Culver St")) {
						Habitant habitant = new Habitant(person, stationNum);
						listHabitant.add(habitant);
					}
				}
			}
		}

		List<Habitant> test = FirestationBusiness.fireBusiness("15010 Culver St", listPerson, getfirestations1);

		assertEquals(listHabitant.toString(), test.toString());
	}

	@Test
	@DisplayName("flood test")
	public void floodBusinessTest() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(person1);
		listPerson.add(person2);

		Map<String, List<Person>> getFoyers = new HashMap<>();
		getFoyers.put("15010 Culver St", listPerson);

		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations1.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations1.get(Integer.parseInt("1"));

			if (fire.getStation() == Integer.parseInt("1")) {
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

		List<Person> test = FirestationBusiness.floodBusiness("1", getfirestations1, getFoyers);

		assertEquals(listPersonResult.toString(), test.toString());
	}

}
