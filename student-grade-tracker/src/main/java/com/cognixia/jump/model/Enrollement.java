package com.cognixia.jump.model;

public class Enrollement {
	
	private int id;
	private int classId;
	private int studentId;
	private String grade1;
	private String grade2;
	private String grade3;
	
	
	public Enrollement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Enrollement(int id, int classId, int studentId, String grade1, String grade2, String grade3) {
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


	public void setStudentId(int student) {
		this.studentId = student;
	}


	public String getGrade1() {
		return grade1;
	}


	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}


	public String getGrade2() {
		return grade2;
	}


	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}


	public String getGrade3() {
		return grade3;
	}


	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}


	@Override
	public String toString() {
		return "Enrollement [id=" + id + ", classId=" + classId + ", studentId=" + studentId + ", grade1=" + grade1
				+ ", grade2=" + grade2 + ", grade3=" + grade3 + "]";
	}

	
	
	
	
}
