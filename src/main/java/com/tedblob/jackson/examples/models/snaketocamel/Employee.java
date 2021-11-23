package com.tedblob.jackson.examples.models.snaketocamel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Employee {

	@JsonProperty("emp_id")
	private long empId;
	@JsonProperty("emp_name")
	private String employeeName;
	
	
	@Override
	public String toString() {
		return "Employee [id=" + empId + ", name=" + employeeName + "]";
	}

}
