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

import com.safetynet.business.Age;
import com.safetynet.business.FirestationBusiness;
import com.safetynet.business.Habitant;
import com.safetynet.business.ListHabitant;
import com.safetynet.business.ListPersonStation;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.SafetyNetModel;

@Controller
public class ControllerFirestation {

	@Autowired
	SafetyNetModel safetyModel;

	private static final Logger logger = LogManager.getRootLogger();

	@PostMapping("/firestation")
	@ResponseBody
	public SafetyNetModel addPersonn(@RequestBody Firestation firestation) {
		safetyModel.getFirestations().add(firestation);

		logger.info("Request = @PostMapping(\"/firestation\") + @RequestBody = {}", firestation);
		logger.info("Response = {}", safetyModel);

		return safetyModel;

	}

	@PutMapping("/firestation")
	@ResponseBody
	public SafetyNetModel updatePerson(@RequestBody Firestation firestation) {
		String address = firestation.getAddress();

		List<Firestation> listFirestation = safetyModel.getFirestations();

		for (Firestation fire : listFirestation) {
			if (fire.getAddress().equals(address)) {
				fire.setStation(firestation.getStation());
			}
		}

		logger.info("Request = @PutMapping(\"/firestation\") + @RequestBody = {}", firestation);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@DeleteMapping("/firestation")
	@ResponseBody
	public SafetyNetModel deleteFirestation(@RequestParam String address) {

		List<Firestation> listFirestation = safetyModel.getFirestations();

		int i = 0;
		int j = 0;
		for (Firestation fire : listFirestation) {
			if (fire.getAddress().equals(address)) {
				i = j;
			}
			i++;
		}

		listFirestation.remove(j);

		logger.info("Request = @DeleteMapping(\"/firestation\") + @RequestParam = {}", address);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@GetMapping("/firestation")
	@ResponseBody
	public ListPersonStation stationNumber(@RequestParam String stationNumber) throws ParseException {

		List<Firestation> listFirestations = safetyModel.getFirestations();
		List<Person> listPersons = safetyModel.getPersons();
		List<Medicalrecord> listMedicalRecords = safetyModel.getMedicalrecords();

		List<Person> listPersonStations = FirestationBusiness.listPersonStations(listPersons, listFirestations,
				stationNumber);

		int nbrAdult = Age.nbrAdult(listPersonStations, listMedicalRecords);
		int nbrChild = listPersonStations.size() - nbrAdult;

		ListPersonStation result = new ListPersonStation(listPersonStations, nbrAdult, nbrChild);

		logger.info("Request = @GetMapping(\"/firestation\" + @RequestParam = {}", stationNumber);
		logger.info("Response {}", result);

		return result;

	}

	@GetMapping("/fire")
	@ResponseBody
	public List<Habitant> fire(@RequestParam String address) throws ParseException {

		List<Person> listPersons = safetyModel.getPersons();
		List<Firestation> listFirestations = safetyModel.getFirestations();
		List<Medicalrecord> listMedicalRecords = safetyModel.getMedicalrecords();

		List<Habitant> result = ListHabitant.listHabitant(listPersons, listMedicalRecords, listFirestations, address);

		logger.info("Request = @GetMapping(\"/fire\" + @RequestParam = {}", address);
		logger.info("Response = {}", result);

		return result;
	}

	@GetMapping("/flood/stations")
	@ResponseBody
	public List<Habitant> flood(@RequestParam String stations) throws ParseException {

		List<Person> listPersons = safetyModel.getPersons();
		List<Firestation> listFirestations = safetyModel.getFirestations();
		List<Medicalrecord> listMedicalRecords = safetyModel.getMedicalrecords();

		List<Habitant> result = ListHabitant.listHabitantStation(listPersons, listMedicalRecords, listFirestations,
				stations);

		logger.info("Request = @GetMapping(\"/flood/stations\" + @RequestParam = {}", stations);
		logger.info("Response = {}", result);

		return result;
	}
}
