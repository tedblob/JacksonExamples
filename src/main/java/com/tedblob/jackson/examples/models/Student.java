package com.tedblob.jackson.examples.models;

public class Student {
	
	public Student(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Student() {
	}

	private long id;
	private String name;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
