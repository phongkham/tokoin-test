package com.tokointest.config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Tokoin configuration class for search project.
 *
 * @author Love
 */
@Configuration
public class TokoinConfig {
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
				.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false)
				.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
	}

	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}
}
