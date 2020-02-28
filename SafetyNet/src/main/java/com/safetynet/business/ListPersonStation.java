package com.safetynet.business;

import java.util.List;

import com.safetynet.model.Person;

public class ListPersonStation {

	private List<Person> listPersStation;
	private int nbrAdult;
	private int nbrChild;

	public ListPersonStation(List<Person> listPersonStation, int nbrAdult, int nbrChild) {
		this.listPersStation = listPersonStation;
		this.nbrAdult = nbrAdult;
		this.nbrChild = nbrChild;
	}

	public List<Person> getListPersonStation() {
		return listPersStation;
	}

	public void setListPersonStation(List<Person> listPersonStation) {
		this.listPersStation = listPersonStation;
	}

	public int getNbrAdult() {
		return nbrAdult;
	}

	public void setNbrAdult(int nbrAdult) {
		this.nbrAdult = nbrAdult;
	}

	public int getNbrChild() {
		return nbrChild;
	}

	public void setNbrChild(int nbrChild) {
		this.nbrChild = nbrChild;
	}

	@Override
	public String toString() {
		return "ListPersonStation [listPersStation=" + listPersStation + ", nbrAdult=" + nbrAdult + ", nbrChild="
				+ nbrChild + "]";
	}

}
