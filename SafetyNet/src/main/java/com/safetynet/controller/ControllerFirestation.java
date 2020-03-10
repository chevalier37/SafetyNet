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
	public SafetyNetModel updatePerson(@RequestBody Map<?, ?> firestation) {

		int stationNumber = Integer.parseInt(firestation.get("station").toString());
		String stationAdress = firestation.get("address").toString();

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
			if (fire.getStation() == stationNumber) {
				fire.addAddress(stationAdress);
			}
		}

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

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
		}

		logger.info("Request = @DeleteMapping(\"/firestation\") + @RequestParam = {}", firestation);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@GetMapping("/firestation")
	@ResponseBody
	public ListPersonStation stationNumber(@RequestParam String stationNumber) throws ParseException {

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();
		List<Person> listSafetyPerson = safetyModel.getPersons();
		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(Integer.parseInt(stationNumber));

			if (fire.getStation() == Integer.parseInt(stationNumber)) {
				addresses = fire.getAddresses();
			}
		}

		for (Person person : listSafetyPerson) {
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

		logger.info("Request = @GetMapping(\"/firestation\" + @RequestParam = {}", stationNumber);
		logger.info("Response {}", listPersonResult);

		return listpersonStation;

	}

	@GetMapping("/fire")
	@ResponseBody
	public List<Habitant> fire(@RequestParam String address) throws ParseException {

		List<Person> listPerson = safetyModel.getPersons();
		List<Habitant> listHabitant = new ArrayList<Habitant>();
		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);

			if (fire.getAddresses().contains(address)) {
				int stationNum = fire.getStation();
				for (Person person : listPerson) {
					if (person.getAddress().equals(address)) {
						Habitant habitant = new Habitant(person, stationNum);
						listHabitant.add(habitant);
					}
				}
			}
		}

		logger.info("Request = @GetMapping(\"/fire\" + @RequestParam = {}", address);
		logger.info("Response = {}", listHabitant);

		return listHabitant;
	}

	@GetMapping("/flood/stations")
	@ResponseBody
	public List<Person> flood(@RequestParam String stations) throws ParseException {

		Map<Integer, Firestation> getfirestations = safetyModel.getFirestations();
		Map<String, List<Person>> getFoyers = safetyModel.getFoyer();
		List<Person> listSafetyPerson = safetyModel.getPersons();
		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();

		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(Integer.parseInt(stations));

			if (fire.getStation() == Integer.parseInt(stations)) {
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

		logger.info("Request = @GetMapping(\"/flood/stations\" + @RequestParam = {}", stations);
		logger.info("Response = {}", listPersonResult);

		return listPersonResult;
	}
}
