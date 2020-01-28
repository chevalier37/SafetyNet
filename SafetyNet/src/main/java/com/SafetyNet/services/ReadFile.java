package com.SafetyNet.services;

import java.io.File;
import java.io.IOException;

import com.SafetyNet.models.SafetyNetModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadFile {
	
	 private static SafetyNetModel safety;
	 
	 public static SafetyNetModel readFile() throws JsonParseException, JsonMappingException, IOException {

	        
	        ObjectMapper objectMapper = new ObjectMapper();
	        

	        safety = objectMapper.readValue(new File("/Users/jean-benoitroussat/desktop/open_classroom/projet_5/data.json"), SafetyNetModel.class);   
		return safety;
		}

	public static SafetyNetModel getSafety() {
		return safety;
	}

	public void setSafety(SafetyNetModel safety) {
		this.safety = safety;
	}

}
