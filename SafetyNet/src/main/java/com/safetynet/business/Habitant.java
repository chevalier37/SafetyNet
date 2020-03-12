package com.safetynet.business;

import com.safetynet.model.Person;

public class Habitant {

	private int age;
	private Person person;
	private int station;

	public Habitant(int age, Person person, int station) {
		this.person = person;
		this.station = station;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "Habitant [person=" + person + ", station=" + station + "]";
	}

}
