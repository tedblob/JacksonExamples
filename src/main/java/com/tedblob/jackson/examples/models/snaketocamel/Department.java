package com.tedblob.jackson.examples.models.snaketocamel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Department {
	
	public Department(long id, String name) {
		this.deptId = id;
		this.deptName = name;
	}
	private String deptName;
	private long deptId;
	
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptId=" + deptId + "]";
	}
}
