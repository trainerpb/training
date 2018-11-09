package com.soham.training.spring.security.MethodLevelSecurityDemo2.srvc;


public class DTO_Day {

	private String name;
	private int x;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public DTO_Day(String name, int x) {
		super();
		this.name = name;
		this.x = x;
	}
	public DTO_Day() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
}
