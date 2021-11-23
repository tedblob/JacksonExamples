package com.tedblob.jackson.examples.snaketocamel;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.tedblob.jackson.examples.models.snaketocamel.Department;
import com.tedblob.jackson.examples.models.snaketocamel.Employee;
import com.tedblob.jackson.examples.models.snaketocamel.Student;

@SpringBootTest
public class JacksonSnakeToCamelTest {
	@Autowired
	Jackson2ObjectMapperBuilder builder;

	@Test
	void snakeToCamel_Default() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"id\": 1001, \"student_name\":\"Praj\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}

	@Test
	void snakeToCamel_Builder() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = builder.build();
		String json = "{\"id\": 1001, \"student_name\":\"Praj\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}

	@Autowired
	ObjectMapper mapper;
	@Test
	void snakeToCamel_Bean() throws JsonMappingException, JsonProcessingException {
		String json = "{\"id\": 1001, \"student_name\":\"Praj\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}

	  
	@Test
	void snakeToCamel_NamingStrategy() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		String json = "{\"id\": 1001, \"student_name\":\"Praj\"}";
		Student student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}
	
	  
	@Test
	void snakeToCamel_JsonNaming() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"dept_id\": 1001, \"dept_name\":\"Praj\"}";
		Department department = mapper.readValue(json, Department.class);
		System.out.println(department);
	}
	@Test
	void snakeToCamel_JsonProperty() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"emp_id\": 1001, \"emp_name\":\"Praj\"}";
		Employee emp = mapper.readValue(json, Employee.class);
		System.out.println(emp);
	}
	
	@Test
	void CamelToSnake_JsonNaming() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		
		Department department = new Department(12123, "Mike");
		System.out.println(mapper.writeValueAsString(department));
	}
}
