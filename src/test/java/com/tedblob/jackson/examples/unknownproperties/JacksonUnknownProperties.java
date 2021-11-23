package com.tedblob.jackson.examples.unknownproperties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tedblob.jackson.examples.models.unknownproperties.Student;

@SpringBootTest
public class JacksonUnknownProperties {

	@Autowired
	Jackson2ObjectMapperBuilder jsonBuilder;
	
	@Test
	void unknownProperties_exception() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"id\": 1001, \"name\": \"Jackson\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}
	
	@Test
	void unknownProperties_configureMapper() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String json = "{\"id\": 1001, \"name\": \"Jackson\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}
	
	@Test
	void unknownProperties_JacksonBuilder() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = jsonBuilder.build();
		String json = "{\"id\": 1001, \"name\": \"Jackson\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}
}
