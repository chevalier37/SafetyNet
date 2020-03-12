package com.safetynet.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.safetynet.business.Enfant;
import com.safetynet.business.PersonBusiness;
import com.safetynet.business.PersonInfo;
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

		listPersons = PersonBusiness.updatePersonBusiness(listPersons, persons, firstname, lastName);

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

		listPersons = PersonBusiness.deletePersonBusiness(firstName, lastName, listPersons);

		logger.info("Request = @DeleteMapping(\"/person\" + @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response = {}", safetyModel);

		return safetyModel;
	}

	@GetMapping("/childAlert")
	@ResponseBody
	public List<Enfant> childAlert(@RequestParam String address) throws ParseException {

		Map<String, List<Person>> foyers = safetyModel.getFoyer();
		List<Enfant> childlist = new ArrayList<Enfant>();

		childlist = PersonBusiness.childAlertBusiness(foyers, childlist, address);

		return childlist;
	}

	@GetMapping("/phoneAlert")
	@ResponseBody
	public List<String> phoneAlert(@RequestParam String firestation) {

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();
		List<Person> listSafetyPerson = safetyModel.getPersons();

		return PersonBusiness.phoneAlertBusiness(firestation, getfirestations, listSafetyPerson);
	}

	@GetMapping("/personInfo")
	@ResponseBody
	public List<PersonInfo> personInfo(@RequestParam String firstName, String lastName) throws ParseException {

		List<Person> listPerson = safetyModel.getPersons();

		return PersonBusiness.personInfoBusiness(firstName, lastName, listPerson);
	}

	@GetMapping("/communityEmail")
	@ResponseBody
	public List<String> communityEmail(@RequestParam String city) {

		List<Person> listSafetyPerson = safetyModel.getPersons();

		return PersonBusiness.communityEmail(city, listSafetyPerson);
	}

}
