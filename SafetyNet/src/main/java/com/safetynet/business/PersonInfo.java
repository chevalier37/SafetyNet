package com.safetynet.business;

import java.util.Arrays;

public class PersonInfo {
	String firstName;
	String lastName;
	String address;
	String mail;
	int age;
	String[] medications;
	String[] allergie;

	public PersonInfo(String firstName, String lastName, String address, String mail, int age, String[] medications,
			String[] allergie) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mail = mail;
		this.age = age;
		this.medications = medications;
		this.allergie = allergie;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getMedications() {
		return medications;
	}

	public void setMedications(String[] medications) {
		this.medications = medications;
	}

	public String[] getAllergie() {
		return allergie;
	}

	public void setAllergie(String[] allergie) {
		this.allergie = allergie;
	}

	@Override
	public String toString() {
		return "PersonInfo [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", mail="
				+ mail + ", age=" + age + ", medications=" + Arrays.toString(medications) + ", allergie="
				+ Arrays.toString(allergie) + "]";
	}

}
