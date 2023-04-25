package com.cognixia.jump.model;

public class Enrollement {
	
	private int id;
	private int classId;
	private int studentId;
	private double grade1;
	private double grade2;
	private double grade3;
	
	
	public Enrollement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Enrollement(int id, int classId, int studentId, double grade1, double grade2, double grade3) {
		super();
		this.id = id;
		this.classId = classId;
		this.studentId = studentId;
		this.grade1 = grade1;
		this.grade2 = grade2;
		this.grade3 = grade3;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public double getGrade1() {
		return grade1;
	}


	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}


	public double getGrade2() {
		return grade2;
	}


	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}


	public double getGrade3() {
		return grade3;
	}


	public void setGrade3(double grade3) {
		this.grade3 = grade3;
	}


	@Override
	public String toString() {
		return "Enrollement [id=" + id + ", classId=" + classId + ", studentId=" + studentId + ", grade1=" + grade1
				+ ", grade2=" + grade2 + ", grade3=" + grade3 + "]";
	}

	
	
}
