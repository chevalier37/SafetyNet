package com.safetynet.controller;

import java.text.ParseException;
import java.util.List;

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

import com.safetynet.business.AlertBusiness;
import com.safetynet.business.Enfant;
import com.safetynet.business.ListPersonInfo;
import com.safetynet.business.PersonInfo;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.SafetyNetModel;

@Controller
public class ControllerPerson {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	SafetyNetModel safetyModel;

	@PostMapping("/person")
	@ResponseBody
	public SafetyNetModel addPersonn(@RequestBody Person persons) {

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
	public SafetyNetModel deletePerson(@RequestParam String firstName, @RequestParam String lastName) {

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

		List<Person> listPersons = safetyModel.getPersons();
		List<Medicalrecord> listMedicalRecords = safetyModel.getMedicalrecords();

		List<Enfant> result = AlertBusiness.childAlert(listPersons, listMedicalRecords, address);

		logger.info("Request = @GetMapping(\"/childAlert\" + @RequestParam = {}", address);
		logger.info("Response = {}", result);

		return result;
	}

	@GetMapping("/phoneAlert")
	@ResponseBody
	public List<String> phoneAlert(@RequestParam String firestation) {

		List<Person> listPersons = safetyModel.getPersons();
		List<Firestation> listFirestations = safetyModel.getFirestations();

		List<String> result = AlertBusiness.phoneAlert(listFirestations, listPersons, firestation);

		logger.info("Request = @GetMapping(\"/phoneAlert\" + @RequestParam = {}", firestation);
		logger.info("Response = {}", result);

		return result;
	}

	@GetMapping("/personInfo")
	@ResponseBody
	public List<PersonInfo> personInfo(@RequestParam String firstName, String lastName) throws ParseException {

		List<Person> listPersons = safetyModel.getPersons();
		List<Medicalrecord> listMedicalRecords = safetyModel.getMedicalrecords();

		List<PersonInfo> result = ListPersonInfo.listPersoninfo(listPersons, listMedicalRecords, firstName, lastName);

		logger.info("Request = @GetMapping(\"/personInfo\" + @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response ={}", result);

		return result;
	}

	@GetMapping("/communityEmail")
	@ResponseBody
	public List<String> communityEmail(@RequestParam String city) {

		List<Person> listPersons = safetyModel.getPersons();

		List<String> result = ListPersonInfo.listEmail(listPersons, city);

		logger.info("Request = @GetMapping(\"/communityEmail\" + @RequestParam = {}", city);
		logger.info("Response {}", result);

		return result;
	}

}
