package persistence2;

import java.util.ArrayList;

public class Course {
	private String cName;
	private ArrayList<String> students;
	private double[] gpa;
	
	public Course(String cNameIn, ArrayList<String> studentsIn, double[] gpaIn) {
		cName = cNameIn;
		students = studentsIn;
		gpa = gpaIn;
		meanGpa(gpaIn);
	}
	
	public boolean equals(Object obj) {
		Boolean equal = false;
	if (obj == this) equal = true;
	if (obj == null || obj.getClass() != this.getClass()) equal =  false;
		Course otherCourse = (Course) obj;
	if (cName.equals(otherCourse.cName) && students.equals(otherCourse.students)) return true;
	return false;
	}
	
	public String meanGpa(double[] gpaIn) {
		double meanGpa = 0;
		int i = 0;
		while(i < gpaIn.length ) {
			meanGpa = meanGpa + gpaIn[i];
			i++;			
		}
		meanGpa = meanGpa / gpaIn.length;
		return "The mean GPA is " + meanGpa;
	}
	public double[] getGpa() {
		return gpa;
	}
	public String toString() {
		return "Course name: " + cName + "; Students: " + students;
	}
	
	public void setCName() {
		this.cName = cName;
	}
	
	public String getCName() {
		return cName;
	}
	
	public void setStudents() {
		this.students = students;
	}
	

	
	public ArrayList<String> getStudents() {
		return students;
	}
}
