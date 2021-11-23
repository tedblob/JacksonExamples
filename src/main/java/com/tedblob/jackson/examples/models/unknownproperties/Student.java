package com.tedblob.jackson.examples.models.unknownproperties;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Student {
	
	public Student(long id) {
		this.id = id;
	}
	
	public Student() {
	}

	public long id;
	
	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
}
