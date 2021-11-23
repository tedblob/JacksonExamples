package com.tedblob.jackson.examples.privatefield;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tedblob.jackson.examples.models.Department;
import com.tedblob.jackson.examples.models.Employee;
import com.tedblob.jackson.examples.models.Student;

@SpringBootTest
public class JacksonPrivateField {

	@Test
	void privateFields_withoutSetterOrGetter() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"id\": 1001}";
		Student student;
		student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}
	@Test
	void privateFields_serialize_withoutSetterOrGetter() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Student student = new Student();
		String studentStr = mapper.writeValueAsString(student);
		System.out.println(studentStr);
	}
	@Test
	void privateFields_serialize_FailOnBeans() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		Student student = new Student(101, "Jack");
		String studentStr = mapper.writeValueAsString(student);
		System.out.println(studentStr);
	}
	
	@Test
	void privateFields_withSetterOnly() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"deptId\": 1001, \"deptName\": \"IT\"}";
		Department department = mapper.readValue(json, Department.class);
		assertThat(department);
	}
	
	@Test
	void privateFields_withVisibilityAny() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\"id\": 1001, \"name\": \"John\"}";
		Employee employee = mapper.readValue(json, Employee.class);
		System.out.println(employee);
	}
	@Test
	void privateFields_serialize_withVisibilityAny() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = new Employee();
		String employeeStr = mapper.writeValueAsString(employee);
		System.out.println("privateFields_serialize_withVisibilityAny" +employeeStr);
	}
	
	@Test
	void privateFields_withoutSetterOrGetter_Visibility() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String json = "{\"id\": 1001}";
		Student student;
		student = mapper.readValue(json, Student.class);
		System.out.println(student);
	}
	
	@Test
	void privateFields_serialize_withoutSetterOrGetter_Visibility() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		Student student = new Student(101, "Jack");
		String studentStr = mapper.writeValueAsString(student);
		System.out.println(studentStr);
	}
}
