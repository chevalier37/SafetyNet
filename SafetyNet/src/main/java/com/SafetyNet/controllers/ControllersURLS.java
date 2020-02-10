package com.SafetyNet.controllers;

import java.text.ParseException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SafetyNet.SafetyNetApplication;
import com.SafetyNet.business.Age;
import com.SafetyNet.business.AlertBusiness;
import com.SafetyNet.business.Enfants;
import com.SafetyNet.business.FirestationBusiness;
import com.SafetyNet.business.Habitant;
import com.SafetyNet.business.ListHabitant;
import com.SafetyNet.business.ListPersonInfo;
import com.SafetyNet.business.ListPersonStation;
import com.SafetyNet.business.PersonInfo;
import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.Medicalrecords;
import com.SafetyNet.models.Persons;
import com.SafetyNet.models.SafetyNetModel;

@RestController
public class ControllersURLS {

	private static final Logger logger = LogManager.getRootLogger();

	@GetMapping("/firestation")
	public ListPersonStation stationNumber(@RequestParam String stationNumber) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<Persons> listPersons = safetyModel.getPersons();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();

		List<Persons> listPersonStations = FirestationBusiness.listPersonStations(listPersons, listFirestations,
				stationNumber);

		int nbrAdult = Age.NbrAdult(listPersonStations, listMedicalRecords);
		int nbrChild = listPersonStations.size() - nbrAdult;

		logger.info("Request = @GetMapping(\"/firestation\" + @RequestParam = " + stationNumber);
		logger.info("Response " + new ListPersonStation(listPersonStations, nbrAdult, nbrChild));

		return new ListPersonStation(listPersonStations, nbrAdult, nbrChild);

	}

	@GetMapping("/childAlert")
	public List<Enfants> childAlert(@RequestParam String address) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Persons> listPersons = safetyModel.getPersons();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();

		logger.info("Request = @GetMapping(\"/childAlert\" + @RequestParam = " + address);
		logger.info("Response " + AlertBusiness.childAlert(listPersons, listMedicalRecords, address));

		return AlertBusiness.childAlert(listPersons, listMedicalRecords, address);
	}

	@GetMapping("/phoneAlert")
	public List<String> phoneAlert(@RequestParam String firestation) {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Persons> listPersons = safetyModel.getPersons();
		List<Firestations> listFirestations = safetyModel.getFirestations();

		logger.info("Request = @GetMapping(\"/phoneAlert\" + @RequestParam = " + firestation);
		logger.info("Response " + AlertBusiness.phoneAlert(listFirestations, listPersons, firestation));

		return AlertBusiness.phoneAlert(listFirestations, listPersons, firestation);
	}

	@GetMapping("/fire")
	public List<Habitant> fire(@RequestParam String address) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Persons> listPersons = safetyModel.getPersons();
		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();

		logger.info("Request = @GetMapping(\"/fire\" + @RequestParam = " + address);
		logger.info(
				"Response " + ListHabitant.listHabitant(listPersons, listMedicalRecords, listFirestations, address));

		return ListHabitant.listHabitant(listPersons, listMedicalRecords, listFirestations, address);
	}

	@GetMapping("/flood/stations")
	public List<Habitant> flood(@RequestParam String stations) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Persons> listPersons = safetyModel.getPersons();
		List<Firestations> listFirestations = safetyModel.getFirestations();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();

		logger.info("Request = @GetMapping(\"/flood/stations\" + @RequestParam = " + stations);
		logger.info("Response "
				+ ListHabitant.listHabitantStation(listPersons, listMedicalRecords, listFirestations, stations));

		return ListHabitant.listHabitantStation(listPersons, listMedicalRecords, listFirestations, stations);
	}

	@GetMapping("/personInfo")
	public List<PersonInfo> personInfo(@RequestParam String firstName, String lastName) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Persons> listPersons = safetyModel.getPersons();
		List<Medicalrecords> listMedicalRecords = safetyModel.getMedicalrecords();

		logger.info("Request = @GetMapping(\"/personInfo\" + @RequestParam = " + firstName + " " + lastName);
		logger.info("Response " + ListPersonInfo.listPersoninfo(listPersons, listMedicalRecords, firstName, lastName));

		return ListPersonInfo.listPersoninfo(listPersons, listMedicalRecords, firstName, lastName);
	}

	@GetMapping("/communityEmail")
	public List<String> communityEmail(@RequestParam String city) throws ParseException {
		SafetyNetModel safetyModel = SafetyNetApplication.model;

		List<Persons> listPersons = safetyModel.getPersons();

		logger.info("Request = @GetMapping(\"/communityEmail\" + @RequestParam = " + city);
		logger.info("Response " + ListPersonInfo.listEmail(listPersons, city));

		return ListPersonInfo.listEmail(listPersons, city);
	}

}
