package com.swagger.entity;

public class Address {
	
    private long addressId;
	private String street;
    private String pinCode;
	public Address(long addressId, String street, String pinCode) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.pinCode = pinCode;
	}
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", pinCode=" + pinCode + "]";
	}
}
