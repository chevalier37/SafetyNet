package com.SafetyNet.app;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.SafetyNet.controllers.ControllersURLS;
import com.SafetyNet.models.SafetyNetModel;

@WebMvcTest(ControllersURLS.class)
@RunWith(SpringRunner.class)
public class IntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	SafetyNetModel safetyModel;

	@Test
	public void stationNumberTest() throws Exception {
		// when(safetyModel).thenReturn(SafetyNetApplication.model);
		this.mockMvc.perform(get("/firestation").param("stationNumber", "2")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}

}
