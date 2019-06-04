package com.beans;

public class Pets {
	private String name;
	private String type;
	
	public Pets() {
		// TODO Auto-generated constructor stub
	}
	public Pets(Object obj) {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "name:"+name+" type:"+type;
	}
	
}
