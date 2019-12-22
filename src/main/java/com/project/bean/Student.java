package com.project.bean;

public class Student 
{
	int rollNumber;
	String name,city;
	
	public Student() 
	{
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollNumber, String name, String city) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.city = city;
	}

	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
	
}
