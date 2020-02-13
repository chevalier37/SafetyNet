package com.SafetyNet.business;

import java.util.List;

import com.SafetyNet.models.Persons;

public class Enfants {
	
	String firstName;
	String lastName;
	int age;
	List<Persons> membreFoyer;
	
	public Enfants(String firstName, String lastName, int age, List<Persons> membreFoyer) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.membreFoyer = membreFoyer;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Persons> getMembreFoyer() {
		return membreFoyer;
	}
	public void setMembreFoyer(List<Persons> membreFoyer) {
		this.membreFoyer = membreFoyer;
	}

	@Override
	public String toString() {
		return "Enfants [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", membreFoyer="
				+ membreFoyer + "]";
	}

}
