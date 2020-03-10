package com.safetynet.business;

import java.util.List;

import com.safetynet.model.Person;

public class Enfant {

	private Person person;
	private List<Person> membreFoyer;

	public Enfant(Person person, List<Person> membreFoyer) {
		super();
		this.person = person;
		this.membreFoyer = membreFoyer;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getMembreFoyer() {
		return membreFoyer;
	}

	public void setMembreFoyer(List<Person> membreFoyer) {
		this.membreFoyer = membreFoyer;
	}

	@Override
	public String toString() {
		return "Enfant [person=" + person + ", membreFoyer=" + membreFoyer + "]";
	}

}
