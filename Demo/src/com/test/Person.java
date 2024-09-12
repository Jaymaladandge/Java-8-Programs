package com.test;

public class Person {

	private String name;
	private Address address;

	public Person(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return new Address(address);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}

	
	public static void main(String[] args) {
		
		Address address1 = new Address("mumbai", "maharashtra");
		Person person = new Person("vijay", new Address("mumbai", "maharashtra"));
		
		Address address = person.getAddress();
		System.out.println("Address : " +address);
		System.out.println("address==address1 : " +(address==address1));
		
		address.setCity("pune");
		System.out.println("Person's address : "+person.getAddress());
	}
}
