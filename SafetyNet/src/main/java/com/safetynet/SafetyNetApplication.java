package com.safetynet;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.safetynet.business.ReadFile;
import com.safetynet.model.SafetyNetModel;

@SpringBootApplication

public class SafetyNetApplication {

	private static String file = "./src/main/resources/data.json";

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetApplication.class, args);
	}

	@Bean
	public SafetyNetModel loadModel() throws IOException {
		return ReadFile.readFile(file);
	}

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

}
