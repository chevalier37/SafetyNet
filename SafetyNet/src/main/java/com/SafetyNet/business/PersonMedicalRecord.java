package com.SafetyNet.business;

import java.util.List;

import com.SafetyNet.models.Medicalrecords;

public class PersonMedicalRecord {

	private String firstName;
	private String lastName;
	private String address;
	private String mail;
	private int age;
	private List<Medicalrecords> medicalrecords;

	public PersonMedicalRecord(String firstName, String lastName, String address, String mail, int age,
			List<Medicalrecords> medicalrecords) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.mail = mail;
		this.age = age;
		this.medicalrecords = medicalrecords;
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

	public List<Medicalrecords> getMedicalrecords() {
		return medicalrecords;
	}

}
