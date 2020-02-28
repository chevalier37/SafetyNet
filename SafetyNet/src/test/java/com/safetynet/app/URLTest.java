package com.SafetyNet.app;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.SafetyNet.controllers.ControllersURLS;

@WebMvcTest(ControllersURLS.class)
@ExtendWith(SpringExtension.class)
public class URLTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void stationNumberTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/firestation").param("stationNumber", "2")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(
						"{\"nbrAdult\":8,\"nbrChild\":2,\"listPersonStation\":[{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7878\",\"email\":\"soph@email.com\"},{\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7512\",\"email\":\"ward@email.com\"},{\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7512\",\"email\":\"zarc@email.com\"},{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"address\":\"29 15th St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7878\",\"email\":\"soph@email.com\"},{\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7512\",\"email\":\"ward@email.com\"},{\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"address\":\"892 Downing Ct\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7512\",\"email\":\"zarc@email.com\"},{\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"address\":\"951 LoneTree Rd\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-7458\",\"email\":\"gramps@email.com\"}]}"));
	}

	@Test
	public void childAlertTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/childAlert").param("address", "1509 Culver St"))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string(
						"[{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"age\":8,\"membreFoyer\":[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"}]},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"age\":3,\"membreFoyer\":[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6513\",\"email\":\"drk@email.com\"},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"tenz@email.com\"},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6512\",\"email\":\"jaboyd@email.com\"},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"city\":\"Culver\",\"zip\":\"97451\",\"phone\":\"841-874-6544\",\"email\":\"jaboyd@email.com\"}]}]"));
	}

	@Test
	public void phoneAlertTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/phoneAlert").param("firestation", "4")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("[\"841-874-9845\",\"841-874-6874\",\"841-874-8888\",\"841-874-9888\"]"));
	}

	@Test
	public void fireTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/fire").param("address", "1509 Culver St")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(
						"[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":36,\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergie\":[\"nillacilan\"],\"station\":\"3\",\"address\":\"1509 Culver St\"},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6513\",\"age\":31,\"medications\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"],\"allergie\":[],\"station\":\"3\",\"address\":\"1509 Culver St\"},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":8,\"medications\":[],\"allergie\":[\"peanut\"],\"station\":\"3\",\"address\":\"1509 Culver St\"},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6512\",\"age\":3,\"medications\":[],\"allergie\":[],\"station\":\"3\",\"address\":\"1509 Culver St\"},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"phone\":\"841-874-6544\",\"age\":34,\"medications\":[\"tetracyclaz:650mg\"],\"allergie\":[\"xilliathal\"],\"station\":\"3\",\"address\":\"1509 Culver St\"}]"));
	}

	@Test
	public void floodTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/flood/stations").param("stations", "2")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(
						"[{\"firstName\":\"Jonanathan\",\"lastName\":\"Marrack\",\"phone\":\"841-874-6513\",\"age\":31,\"medications\":[],\"allergie\":[],\"station\":\"2\",\"address\":\"29 15th St\"},{\"firstName\":\"Sophia\",\"lastName\":\"Zemicks\",\"phone\":\"841-874-7878\",\"age\":32,\"medications\":[\"aznol:60mg\",\"hydrapermazol:900mg\",\"pharmacol:5000mg\",\"terazine:500mg\"],\"allergie\":[\"peanut\",\"shellfish\",\"aznol\"],\"station\":\"2\",\"address\":\"892 Downing Ct\"},{\"firstName\":\"Warren\",\"lastName\":\"Zemicks\",\"phone\":\"841-874-7512\",\"age\":35,\"medications\":[],\"allergie\":[],\"station\":\"2\",\"address\":\"892 Downing Ct\"},{\"firstName\":\"Zach\",\"lastName\":\"Zemicks\",\"phone\":\"841-874-7512\",\"age\":3,\"medications\":[],\"allergie\":[],\"station\":\"2\",\"address\":\"892 Downing Ct\"},{\"firstName\":\"Eric\",\"lastName\":\"Cadigan\",\"phone\":\"841-874-7458\",\"age\":75,\"medications\":[\"tradoxidine:400mg\"],\"allergie\":[],\"station\":\"2\",\"address\":\"951 LoneTree Rd\"}]"));
	}

	@Test
	public void personInfoTest() throws Exception {

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/personInfo").param("firstName", "John").param("lastName", "Boyd"))
				.andDo(print()).andExpect(status().isOk()).andExpect(content().string(
						"[{\"firstName\":\"John\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"mail\":\"jaboyd@email.com\",\"age\":36,\"medications\":[\"aznol:350mg\",\"hydrapermazol:100mg\"],\"allergie\":[\"nillacilan\"]},{\"firstName\":\"Jacob\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"mail\":\"jaboyd@email.com\",\"age\":31,\"medications\":[\"pharmacol:5000mg\",\"terazine:10mg\",\"noznazol:250mg\"],\"allergie\":[]},{\"firstName\":\"Tenley\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"mail\":\"jaboyd@email.com\",\"age\":8,\"medications\":[],\"allergie\":[\"peanut\"]},{\"firstName\":\"Roger\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"mail\":\"jaboyd@email.com\",\"age\":3,\"medications\":[],\"allergie\":[]},{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"mail\":\"jaboyd@email.com\",\"age\":34,\"medications\":[\"tetracyclaz:650mg\"],\"allergie\":[\"xilliathal\"]},{\"firstName\":\"Allison\",\"lastName\":\"Boyd\",\"address\":\"1509 Culver St\",\"mail\":\"jaboyd@email.com\",\"age\":55,\"medications\":[\"aznol:200mg\"],\"allergie\":[\"nillacilan\"]}]"));
	}

	@Test
	public void communityEmailTest() throws Exception {

		this.mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail").param("city", "Culver")).andDo(print())
				.andExpect(status().isOk()).andExpect(content().string(
						"[\"jaboyd@email.com\",\"drk@email.com\",\"tenz@email.com\",\"jaboyd@email.com\",\"jaboyd@email.com\",\"drk@email.com\",\"tenz@email.com\",\"jaboyd@email.com\",\"jaboyd@email.com\",\"tcoop@ymail.com\",\"lily@email.com\",\"soph@email.com\",\"ward@email.com\",\"zarc@email.com\",\"reg@email.com\",\"jpeter@email.com\",\"jpeter@email.com\",\"aly@imail.com\",\"bstel@email.com\",\"ssanw@email.com\",\"bstel@email.com\",\"clivfd@ymail.com\",\"gramps@email.com\"]"));
	}

}
