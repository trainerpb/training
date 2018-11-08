package com.soham.training.spring.security.MethodLevelDemo1.dto;


public class DTO_Player {

	private String name;
	private int run;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public DTO_Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTO_Player(String name, int run) {
		super();
		this.name = name;
		this.run = run;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+" scored "+run;
	}
	
}
