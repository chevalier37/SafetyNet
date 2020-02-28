package com.safetynet.controller;

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

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.SafetyNetModel;

@Controller
public class ControllerMedicalRecord {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	SafetyNetModel safetyModel;

	@PostMapping("/medicalRecord")
	@ResponseBody
	public SafetyNetModel addMedicalRecord(@RequestBody Medicalrecord medicalRecord) {

		safetyModel.getMedicalrecords().add(medicalRecord);

		logger.info("Request = @PostMapping(\"/medicalRecord\" + @RequestBody = {}", medicalRecord);
		logger.info("Response = {}", safetyModel);

		return safetyModel;
	}

	@PutMapping("/medicalRecord")
	@ResponseBody
	public SafetyNetModel updateMedicalRecord(@RequestBody Medicalrecord medicalRecord) {
		String firstname = medicalRecord.getFirstName();
		String lastName = medicalRecord.getLastName();

		List<Medicalrecord> listMedicalRecord = safetyModel.getMedicalrecords();

		for (Medicalrecord medi : listMedicalRecord) {
			if (medi.getFirstName().equals(firstname) && medi.getLastName().equals(lastName)) {
				medi.setBirthdate(medicalRecord.getBirthdate());
				medi.setMedications(medicalRecord.getMedications());
				medi.setAllergies(medicalRecord.getAllergies());

			}
		}

		logger.info("Request = @PutMapping(\"/medicalRecord\" + @RequestBody = {}", medicalRecord);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

	@DeleteMapping("/medicalRecord")
	@ResponseBody
	public SafetyNetModel deleteMedicalRecord(@RequestParam String firstName, @RequestParam String lastName) {

		List<Medicalrecord> listMedicalRecord = safetyModel.getMedicalrecords();

		int i = 0;
		int j = 0;
		for (Medicalrecord medi : listMedicalRecord) {
			if (medi.getFirstName().equals(firstName) && medi.getLastName().equals(lastName)) {
				i = j;
			}
			i++;
		}

		listMedicalRecord.remove(j);

		logger.info("Request = @DeleteMapping(\"/medicalRecord\" + @RequestParam = {} + {}", firstName, lastName);
		logger.info("Response {}", safetyModel);

		return safetyModel;
	}

}
