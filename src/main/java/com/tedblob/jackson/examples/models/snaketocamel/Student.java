package com.tedblob.jackson.examples.models.snaketocamel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Student {
	
	public Student(long id, String studentName) {
		this.id = id;
		this.studentName = studentName;
	}
	
	public Student() {	}

	private long id;
	private String studentName;
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentName=" + studentName + "]";
	}

}
