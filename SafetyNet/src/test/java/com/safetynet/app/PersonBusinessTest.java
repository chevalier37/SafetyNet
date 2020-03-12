package com.safetynet.app;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.safetynet.business.PersonBusiness;
import com.safetynet.business.PersonInfo;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class PersonBusinessTest {

	@Test
	@DisplayName("Update Person test")
	public void updatePersonBusinessTest() {

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

		List<Person> test = PersonBusiness.updatePersonBusiness(listPerson, person1, "name1", "lastname1");

		assertEquals(listPerson.toString(), test.toString());
	}

	@Test
	@DisplayName("Delete Person test")
	public void deletePersonBusinessTest() {

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

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);

		List<Person> listPerson2 = new ArrayList<>();
		listPerson2.add(person2);

		List<Person> test = PersonBusiness.deletePersonBusiness("name1", "lastname1", listPerson1);

		assertEquals(listPerson2.toString(), test.toString());
	}

	@Test
	@DisplayName("phone Alert test")
	public void phoneAlertBusiness() {

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

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);
		List<String> phoneList = new ArrayList<>();
		phoneList.add("123-123");
		phoneList.add("123-123");

		List<String> test = PersonBusiness.phoneAlertBusiness("1", getfirestations1, listPerson1);

		assertEquals(phoneList.toString(), test.toString());
	}

	@Test
	@DisplayName("person info test")
	public void personInfoBusinessTest() throws ParseException {

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

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);

		PersonInfo person3 = new PersonInfo("name1", "lastname1", 35, "15010 Culver St", "city1", "007", "123-123",
				"de@de.fr", Medicalrecords1);
		PersonInfo person4 = new PersonInfo("name2", "lastname2", 9, "15010 Culver St", "city1", "007", "123-123",
				"de@de.fr", Medicalrecords2);

		List<PersonInfo> listPerson2 = new ArrayList<>();
		listPerson2.add(person3);

		List<PersonInfo> test = PersonBusiness.personInfoBusiness("name1", "lastname1", listPerson1);

		assertEquals(listPerson2.toString(), test.toString());
	}

	@Test
	@DisplayName("Community Email test")
	public void communityEmail() {

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

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);

		List<String> mailList = new ArrayList<>();
		mailList.add("de@de.fr");
		mailList.add("de@de.fr");

		List<String> test = PersonBusiness.communityEmail("city1", listPerson1);

		assertEquals(mailList.toString(), test.toString());
	}

}
