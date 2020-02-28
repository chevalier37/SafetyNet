package com.safetynet.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;

public class Age {

	private Age() {

	}

	private static Calendar today = Calendar.getInstance();
	private static Logger logger = LogManager.getRootLogger();
	private static Calendar birthDay = Calendar.getInstance();
	private static final String formatDate = "MM/dd/yyyy";

	public static boolean isAdult(String birthD) throws ParseException {
		int yearDiff = yearDiff(birthD);
		int monthDiff = monthDiff(birthD);
		int dayDiff = dayDiff(birthD);

		if (yearDiff > 18 || yearDiff == 18 && monthDiff >= 0 || yearDiff == 18 && monthDiff == 0 && dayDiff >= 0) {
			logger.debug("isAdult = {}", true);
			return true;
		} else {
			logger.debug("isAdult =  {}", false);
			return false;
		}
	}

	public static int calculAge(String birthD) throws ParseException {
		int yearDiff = yearDiff(birthD);
		int monthDiff = monthDiff(birthD);
		int dayDiff = dayDiff(birthD);

		if (monthDiff > 0 || (monthDiff == 0 && dayDiff >= 0)) {
			logger.debug("year =  {}", yearDiff);
			return yearDiff;
		} else {
			logger.debug("year =  {}", (yearDiff - 1));
			return yearDiff - 1;
		}

	}

	public static int nbrAdult(List<Person> listPersonStations, List<Medicalrecord> listMedicalRecords)
			throws ParseException {
		int nbAdultes = 0;
		for (Person personStation : listPersonStations) {
			for (Medicalrecord medical : listMedicalRecords) {
				if (personStation.getFirstName().equals(medical.getFirstName())
						&& personStation.getLastName().equals(medical.getLastName())) {
					if (Age.isAdult(medical.getBirthdate())) {
						nbAdultes++;
					}
				}
			}
		}
		logger.debug("nbrAdultes =  {}", nbAdultes);
		return nbAdultes;
	}

	private static int yearDiff(String birthD) throws ParseException {
		Date birth = new SimpleDateFormat(formatDate).parse(birthD);
		birthDay.setTime(birth);
		return today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
	}

	private static int monthDiff(String birthD) throws ParseException {
		Date birth = new SimpleDateFormat(formatDate).parse(birthD);
		birthDay.setTime(birth);
		return today.MONTH - birthDay.MONTH;
	}

	private static int dayDiff(String birthD) throws ParseException {
		Date birth = new SimpleDateFormat(formatDate).parse(birthD);
		birthDay.setTime(birth);
		return today.DAY_OF_MONTH - birthDay.DAY_OF_MONTH;
	}

}
