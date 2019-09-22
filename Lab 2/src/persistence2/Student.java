package persistence2;

public class Student {
	
	private String firstName;
	private String lastName;
	private String name;
	private Double gpa;
	
	public Student(String firstNameIn, String lastNameIn, Double gpaIn) {
		firstName = firstNameIn;
		lastName = lastNameIn;
		name = firstName + lastName;
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
		return "Name: " + firstName + lastName + "; GPA: " + gpa;
	}
	
	public void setFirstName() {
		this.firstName = firstName;
	}
	
	public String getName() {
		return firstName + lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setGpa() {
		this.gpa = gpa;
	}
	
	public Double getGpa() {
		return gpa;
	}
}
