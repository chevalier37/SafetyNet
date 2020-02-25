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

import com.SafetyNet.models.Firestations;
import com.SafetyNet.models.SafetyNetModel;

@Controller
public class ControllersFirestations {

	@Autowired
	SafetyNetModel safetyModel;

	private static final Logger logger = LogManager.getRootLogger();

	@PostMapping("/firestation")
	@ResponseBody
	public SafetyNetModel addPersonn(@RequestBody Firestations firestation) {
		safetyModel.getFirestations().add(firestation);

		logger.info("Request = @PostMapping(\"/firestation\") + @RequestBody = {}", firestation);
		logger.info("Response = {}", safetyModel);

		return safetyModel;

	}

	@PutMapping("/firestation")
	@ResponseBody
	public SafetyNetModel updatePerson(@RequestBody Firestations firestation) {
		String address = firestation.getAddress();

		List<Firestations> listFirestation = safetyModel.getFirestations();

		for (Firestations fire : listFirestation) {
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

		List<Firestations> listFirestation = safetyModel.getFirestations();

		int i = 0;
		int j = 0;
		for (Firestations fire : listFirestation) {
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
}
