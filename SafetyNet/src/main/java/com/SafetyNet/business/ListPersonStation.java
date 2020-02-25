package com.SafetyNet.business;

import java.util.List;

import com.SafetyNet.models.Persons;

public class ListPersonStation {

	private List<Persons> listPersStation;
	private int nbrAdult;
	private int nbrChild;

	public ListPersonStation(List<Persons> listPersonStation, int nbrAdult, int nbrChild) {
		this.listPersStation = listPersonStation;
		this.nbrAdult = nbrAdult;
		this.nbrChild = nbrChild;
	}

	public List<Persons> getListPersonStation() {
		return listPersStation;
	}

	public void setListPersonStation(List<Persons> listPersonStation) {
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
