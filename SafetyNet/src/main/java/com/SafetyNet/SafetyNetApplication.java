package com.SafetyNet;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SafetyNet.business.ReadFile;
import com.SafetyNet.models.SafetyNetModel;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
public class SafetyNetApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetApplication.class, args);
	}

	@Bean
	public SafetyNetModel loadModel() throws JsonParseException, JsonMappingException, IOException {
		return ReadFile.readFile();
	}

}
