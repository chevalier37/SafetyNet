package com.SafetyNet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.business.Age;

@SpringBootTest
public class AgeTest {

	@Test
	@DisplayName("calcul age")
	public void ageCalcul() throws ParseException {
		int age = Age.calculAge("01/01/2000");
		assertEquals(20, age);
	}

	@Test
	@DisplayName("is majeur")
	public void isMajeurTest() throws ParseException {
		boolean isMajeur = Age.isAdult("01/01/2000");
		assertEquals(true, isMajeur);
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("calculate Fare Bike >1day") public void
	 * calculateFareBikeWithMoreThanADayParkingTime() throws ParseException {
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm"); Date inTime
	 * = sdf.parse("1982/03/24 09:30"); Date outTime =
	 * sdf.parse("1982/03/26 09:30"); ParkingSpot parkingSpot = new ParkingSpot(1,
	 * ParkingType.BIKE, false);
	 * 
	 * ticket.setInTime(inTime); ticket.setOutTime(outTime);
	 * ticket.setParkingSpot(parkingSpot);
	 * fareCalculatorService.calculateFare(ticket, applyReduction); assertEquals((48
	 * * Fare.BIKE_RATE_PER_HOUR), ticket.getPrice()); }
	 */

}
