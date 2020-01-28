package com.SafetyNet;



import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SafetyNet.models.SafetyNetModel;
import com.SafetyNet.services.ReadFile;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;



@SpringBootApplication
public class SafetyNetApplication  {	
	public static SafetyNetModel model;
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetApplication.class, args);	
		model = ReadFile.readFile();
		
		
		 
	}

}
