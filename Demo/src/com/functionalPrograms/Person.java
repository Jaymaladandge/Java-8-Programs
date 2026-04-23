package com.functionalPrograms;

public class Person {

	private String name;
	private String city;
	private String state;
	private double salary;

	public Person() {
		super();
	}

	public Person(String name, String city, String state, double salary) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.salary = salary;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + ", state=" + state + ", salary=" + salary + "]";
	}

	
}
