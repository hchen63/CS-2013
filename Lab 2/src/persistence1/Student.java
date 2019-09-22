package persistence1;

public class Student {
	
	private String name ;
	private Double gpa;
	
	public Student(String nameIn, Double gpaIn) {
		name = nameIn;
		gpa = gpaIn;
	}

	
	public boolean equals(Object obj) {
		Boolean equal = false;
	if (obj == this) equal = true;
	if (obj == null || obj.getClass() != this.getClass()) equal =  false;
		Student otherStudent = (Student) obj;
	if (name.equals(otherStudent.name) && gpa.equals(otherStudent.gpa)) return true;
	return false;
}

	public String toString() {
		return "Name: " + name + "; GPA: " + gpa;
	}
	
	public void setName() {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGpa() {
		this.gpa = gpa;
	}
	
	public Double getGpa() {
		return gpa;
	}
}
