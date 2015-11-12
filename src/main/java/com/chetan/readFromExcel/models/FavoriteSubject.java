package com.chetan.readFromExcel.models;

public class FavoriteSubject {

	private String studentName;
	private String subjectName;

	public FavoriteSubject() {
		// TODO Auto-generated constructor stub
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "Student: " + this.getStudentName() + ", "
				+ "Favorite Subject: " + this.getSubjectName() + "\n";
	}

}
