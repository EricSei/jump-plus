package com.cognixia.jump.model;

public class SchoolClass {
	
	private int id;
	private String name;
	private int teacherId;
	public SchoolClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SchoolClass(int id, String name, int teacherId) {
		super();
		this.id = id;
		this.name = name;
		this.teacherId = teacherId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", teacherId=" + teacherId + "]";
	}
	
	
}
