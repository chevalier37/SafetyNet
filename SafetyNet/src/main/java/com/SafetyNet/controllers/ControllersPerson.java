package com.SafetyNet.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SafetyNet.models.Persons;
import com.SafetyNet.models.SafetyNetModel;

@Controller
public class ControllersPerson {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	SafetyNetModel safetyModel;

	@PostMapping("/person")
	@ResponseBody
	public SafetyNetModel addPersonn(@RequestBody Persons persons) {

		safetyModel.getPersons().add(persons);

		logger.info("Request = @PostMapping(\"/person\" + @RequestBody = {}", persons);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@PutMapping("/person")
	@ResponseBody
	public SafetyNetModel updatePerson(@RequestBody Persons persons) {
		String firstname = persons.getFirstName();
		String lastName = persons.getLastName();

		List<Persons> listPersons = safetyModel.getPersons();

		for (Persons pers : listPersons) {
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
	public SafetyNetModel deletePerson(@RequestParam String firstName, @RequestParam String lastName) {

		List<Persons> listPersons = safetyModel.getPersons();

		int i = 0;
		int j = 0;
		for (Persons pers : listPersons) {
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

}
