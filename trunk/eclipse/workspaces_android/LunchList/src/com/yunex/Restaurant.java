package com.yunex;

public class Restaurant {

	private String name = "";
	private String address = "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", address=" + address + "]";
	}
}
