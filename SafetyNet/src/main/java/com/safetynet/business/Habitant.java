package com.safetynet.business;

import com.safetynet.model.Person;

public class Habitant {

	private Person person;
	private int station;

	public Habitant(Person person, int station) {
		super();
		this.person = person;
		this.station = station;
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
