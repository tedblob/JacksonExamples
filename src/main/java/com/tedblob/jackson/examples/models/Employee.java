package com.tedblob.jackson.examples.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Employee {
	
	private long id;
	private String name;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
