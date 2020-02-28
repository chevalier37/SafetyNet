package com.safetynet.business;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.model.SafetyNetModel;

public class ReadFile {

	private ReadFile() {
	}

	public static SafetyNetModel readFile(String file) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(new File(file), SafetyNetModel.class);
	}

}
