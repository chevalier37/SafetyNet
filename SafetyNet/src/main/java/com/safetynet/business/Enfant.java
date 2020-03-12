package com.safetynet.business;

import java.util.List;

import com.safetynet.model.Person;

public class Enfant {

	private int age;
	private Person person;
	private List<Person> membreFoyer;

	public Enfant(int age, Person person, List<Person> membreFoyer) {
		this.person = person;
		this.membreFoyer = membreFoyer;
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
