package com.safetynet.app;

import java.util.HashSet;
import java.util.Set;

public class ModelFirestationTest {

	private int station;
	private Set<String> addresses = new HashSet<>();

	public ModelFirestationTest(int station, Set<String> addresses) {
		this.station = station;
		this.addresses = addresses;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public void setAddresses(Set<String> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getAddresses() {
		return addresses;
	}

	public int getStation() {
		return station;
	}

	public void addAddress(String newAddress) {
		addresses.add(newAddress);
	}

	@Override
	public String toString() {
		return "Firestation [station=" + station + ", addresses=" + addresses + "]";
	}

}
