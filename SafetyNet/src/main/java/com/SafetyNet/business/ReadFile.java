package com.SafetyNet.business;

import java.io.File;
import java.io.IOException;

import com.SafetyNet.models.SafetyNetModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {

	static String file = "/Users/jean-benoitroussat/desktop/open_classroom/projet_5/data.json";

	public static SafetyNetModel readFile() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();

		return objectMapper.readValue(new File(file), SafetyNetModel.class);

	}

}
