package com.safetynet.controller;

import java.text.ParseException;
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

import com.safetynet.business.FirestationBusiness;
import com.safetynet.business.Habitant;
import com.safetynet.business.ListPersonStation;
import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.SafetyNetModel;

@Controller
public class ControllerFirestation {

	@Autowired
	SafetyNetModel safetyModel;

	private static final Logger logger = LogManager.getRootLogger();

	@PostMapping("/firestation")
	@ResponseBody
	public SafetyNetModel addPersonn(@RequestBody Map<?, ?> firestation) {

		int stationNumber = Integer.parseInt(firestation.get("station").toString());
		String stationAdress = firestation.get("address").toString();

		Firestation getfirestations = safetyModel.getFirestations().get(stationNumber);
		getfirestations.addAddress(stationAdress);

		logger.info("Request = @PostMapping(\"/firestation\") + @RequestBody = {}", firestation);
		logger.info("Response = {}", safetyModel);

		return safetyModel;
	}

	@PutMapping("/firestation")
	@ResponseBody
	public SafetyNetModel updateFirestation(@RequestBody Map<?, ?> firestation) {

		int stationNumber = Integer.parseInt(firestation.get("station").toString());
		String stationAdress = firestation.get("address").toString();

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();

		getfirestations = FirestationBusiness.updateFirestationBusiness(stationNumber, stationAdress, getfirestations);

		logger.info("Request = @PutMapping(\"/firestation\") + @RequestBody = {}", firestation);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@DeleteMapping("/firestation")
	@ResponseBody
	public SafetyNetModel deleteFirestation(@RequestBody Map<?, ?> firestation) {

		int stationNumber = Integer.parseInt(firestation.get("station").toString());
		String stationAdress = firestation.get("address").toString();

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();

		getfirestations = FirestationBusiness.deleteFirestationBusiness(stationNumber, stationAdress, getfirestations);

		logger.info("Request = @DeleteMapping(\"/firestation\") + @RequestParam = {}", firestation);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@GetMapping("/firestation")
	@ResponseBody
	public ListPersonStation stationNumber(@RequestParam String stationNumber) throws ParseException {

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();
		List<Person> listSafetyPerson = safetyModel.getPersons();

		ListPersonStation listpersonStation = FirestationBusiness.stationNumberBusiness(stationNumber, getfirestations,
				listSafetyPerson);

		logger.info("Request = @GetMapping(\"/firestation\" + @RequestParam = {}", stationNumber);
		logger.info("Response {}", listpersonStation);

		return listpersonStation;

	}

	@GetMapping("/fire")
	@ResponseBody
	public List<Habitant> fire(@RequestParam String address) throws ParseException {

		List<Person> listPerson = safetyModel.getPersons();
		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();

		List<Habitant> listHabitant = FirestationBusiness.fireBusiness(address, listPerson, getfirestations);

		logger.info("Request = @GetMapping(\"/fire\" + @RequestParam = {}", address);
		logger.info("Response = {}", listHabitant);

		return listHabitant;
	}

	@GetMapping("/flood/stations")
	@ResponseBody
	public List<Person> flood(@RequestParam String stations) throws ParseException {

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();
		Map<String, List<Person>> getFoyers = safetyModel.getFoyer();

		List<Person> listPersonResult = FirestationBusiness.floodBusiness(stations, getfirestations, getFoyers);

		logger.info("Request = @GetMapping(\"/flood/stations\" + @RequestParam = {}", stations);
		logger.info("Response = {}", listPersonResult);

		return listPersonResult;
	}
}
