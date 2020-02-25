package com.SafetyNet.business;

public class Habitant {

	String firstName;
	String lastName;
	String phone;
	int age;
	String[] medications;
	String[] allergie;
	String station;
	String address;

	public Habitant(String firstName, String lastName, String phone, int age, String[] medications, String[] allergie,
			String station, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergie = allergie;
		this.station = station;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "Habitants [firstName=" + firstName + ", LastName=" + lastName + ", phone=" + phone + ", age=" + age
				+ ", medications=" + medications + ", allergie=" + allergie + ", station=" + station + "]";
	}
}
