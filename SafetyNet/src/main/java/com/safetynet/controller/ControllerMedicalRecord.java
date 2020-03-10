package com.safetynet.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.SafetyNetModel;

@Controller
public class ControllerMedicalRecord {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	SafetyNetModel safetyModel;

	@PostMapping("/medicalRecord")
	@ResponseBody
	public SafetyNetModel addMedicalRecord(@RequestBody Map<?, ?> medicalRecord) {

		String firstName = medicalRecord.get("firstName").toString();
		String lastName = medicalRecord.get("lastName").toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = medicalRecord.get("birthdate").toString();
		LocalDate bithDate = LocalDate.parse(date, formatter);
		List<String> medications = (List<String>) medicalRecord.get("medications");
		List<String> allergies = (List<String>) medicalRecord.get("allergies");

		Medicalrecord medicalrecord = new Medicalrecord(bithDate, medications, allergies);
		List<Person> persons = safetyModel.getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				person.setMedicalRecord(medicalrecord);
			}
		}

		logger.info("Request = @PostMapping(\"/medicalRecord\" + @RequestBody = {}", medicalRecord);
		logger.info("Response = {}", safetyModel);

		return safetyModel;
	}

	@PutMapping("/medicalRecord")
	@ResponseBody
	public SafetyNetModel updateMedicalRecord(@RequestBody Map<?, ?> medicalRecord) {

		String firstName = medicalRecord.get("firstName").toString();
		String lastName = medicalRecord.get("lastName").toString();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = medicalRecord.get("birthdate").toString();
		LocalDate bithDate = LocalDate.parse(date, formatter);
		List<String> medications = (List<String>) medicalRecord.get("medications");
		List<String> allergies = (List<String>) medicalRecord.get("allergies");

		Medicalrecord medicalrecord = new Medicalrecord(bithDate, medications, allergies);
		List<Person> persons = safetyModel.getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				person.setMedicalRecord(medicalrecord);
			}
		}

		logger.info("Request = @PutMapping(\"/medicalRecord\" + @RequestBody = {}", medicalRecord);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@DeleteMapping("/medicalRecord")
	@ResponseBody
	public SafetyNetModel deleteMedicalRecord(@RequestBody Map<?, ?> medicalRecord) {

		String firstName = medicalRecord.get("firstName").toString();
		String lastName = medicalRecord.get("lastName").toString();

		List<Person> persons = safetyModel.getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
				person.getMedicalRecord().getAllergies().clear();
				person.getMedicalRecord().getMedications().clear();
			}
		}

		logger.info("Request = @DeleteMapping(\"/medicalRecord\" + @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

}
