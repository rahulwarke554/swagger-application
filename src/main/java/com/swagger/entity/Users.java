package com.swagger.entity;

public class Users {
	
	
	private long userId;
	
	private String name;
	
	private String dob;
	
	private String gender;
	
	public Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", address="
				+ address + "]";
	}
}
