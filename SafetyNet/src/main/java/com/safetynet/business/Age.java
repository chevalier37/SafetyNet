package com.safetynet.business;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Age {

	private Age() {

	}

	private static Calendar today = Calendar.getInstance();
	private static Logger logger = LogManager.getRootLogger();
	private static Calendar birthDay = Calendar.getInstance();
	private static final String formatDate = "MM/dd/yyyy";

	public static boolean isAdult(LocalDate birthD) throws ParseException {
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

	private static int yearDiff(LocalDate birthD) throws ParseException {
		int birth = birthD.getYear();
		return today.get(Calendar.YEAR) - birth;
	}

	private static int monthDiff(LocalDate birthD) throws ParseException {
		int birth = birthD.getMonthValue();
		return today.MONTH - birth;
	}

	private static int dayDiff(LocalDate birthD) throws ParseException {
		int birth = birthD.getDayOfMonth();
		return today.DAY_OF_MONTH - birth;
	}

}
