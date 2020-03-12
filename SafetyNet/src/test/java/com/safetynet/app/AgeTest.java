package com.safetynet.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.business.Age;

@SpringBootTest
public class AgeTest {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	String date1 = "03/06/1984";
	LocalDate birthdate1 = LocalDate.parse(date1, formatter);

	@Test
	@DisplayName("is majeur")
	public void isMajeurTest() throws ParseException {
		boolean isMajeur = Age.isAdult(birthdate1);
		assertEquals(true, isMajeur);
	}

	@Test
	@DisplayName("calcul age")
	public void calculAgeTest() throws ParseException {
		int age = Age.calculAge(birthdate1);
		assertEquals(35, age);
	}

}
