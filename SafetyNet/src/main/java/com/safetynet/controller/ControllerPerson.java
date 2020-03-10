package com.safetynet.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safetynet.business.Age;
import com.safetynet.business.Enfant;
import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.SafetyNetModel;

@Controller
public class ControllerPerson {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	SafetyNetModel safetyModel;

	@PostMapping("/person")
	@ResponseBody
	public SafetyNetModel addPersonn(@RequestBody Map<?, ?> person) {

		String firstName = person.get("firstName").toString();
		String lastName = person.get("lastName").toString();
		String address = person.get("address").toString();
		String city = person.get("city").toString();
		String zip = person.get("zip").toString();
		String phone = person.get("phone").toString();
		String email = person.get("email").toString();

		Person persons = new Person(firstName, lastName, address, city, zip, phone, email);
		safetyModel.getPersons().add(persons);

		logger.info("Request = @PostMapping(\"/person\" + @RequestBody = {}", persons);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@PutMapping("/person")
	@ResponseBody
	public SafetyNetModel updatePerson(@RequestBody Person persons) {
		String firstname = persons.getFirstName();
		String lastName = persons.getLastName();

		List<Person> listPersons = safetyModel.getPersons();

		for (Person pers : listPersons) {
			if (pers.getFirstName().equals(firstname) && pers.getLastName().equals(lastName)) {
				pers.setAddress(persons.getAddress());
				pers.setCity(persons.getCity());
				pers.setZip(persons.getZip());
				pers.setPhone(persons.getPhone());
				pers.setEmail(persons.getEmail());
			}
		}

		logger.info("Request = @PutMapping(\"/person\" + @RequestBody = {}", persons);
		logger.info("Response ={}", safetyModel);

		return safetyModel;
	}

	@DeleteMapping("/person")
	@ResponseBody
	public SafetyNetModel deletePerson(@RequestBody Map<?, ?> person) {

		String firstName = person.get("firstName").toString();
		String lastName = person.get("lastName").toString();

		List<Person> listPersons = safetyModel.getPersons();

		int i = 0;
		int j = 0;
		for (Person pers : listPersons) {
			if (pers.getFirstName().equals(firstName) && pers.getLastName().equals(lastName)) {
				i = j;
			}
			i++;
		}

		listPersons.remove(j);

		logger.info("Request = @DeleteMapping(\"/person\" + @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response = {}", safetyModel);

		return safetyModel;
	}

	@GetMapping("/childAlert")
	@ResponseBody
	public List<Enfant> childAlert(@RequestParam String address) throws ParseException {

		Map<String, List<Person>> foyers = safetyModel.getFoyer();
		List<Enfant> childlist = new ArrayList<Enfant>();

		Set cles = foyers.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()) {
			Object foyerNum = it.next();
			List<Person> listFoyers = foyers.get(foyerNum);
			for (Person person : listFoyers) {
				if (!Age.isAdult(person.getMedicalRecord().getBirthdate())) {
					Enfant child = new Enfant(person, listFoyers);
					childlist.add(child);
				}
			}
		}

		return childlist;
	}

	@GetMapping("/phoneAlert")
	@ResponseBody
	public List<String> phoneAlert(@RequestParam String firestation) {

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();
		List<Person> listSafetyPerson = safetyModel.getPersons();
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

	@GetMapping("/personInfo")
	@ResponseBody
	public List<Person> personInfo(@RequestParam String firstName, String lastName) throws ParseException {

		List<Person> listPerson = safetyModel.getPersons();
		List<Person> listPersonResult = new ArrayList<Person>();

		for (Person person : listPerson) {
			if (person.getLastName().equals(lastName)) {
				listPersonResult.add(person);
			}
		}
		return listPersonResult;
	}

	@GetMapping("/communityEmail")
	@ResponseBody
	public List<String> communityEmail(@RequestParam String city) {

		List<Person> listSafetyPerson = safetyModel.getPersons();
		List<String> listEmail = new ArrayList<String>();

		for (Person person : listSafetyPerson) {
			listEmail.add(person.getEmail());
		}
		return listEmail;
	}

}
