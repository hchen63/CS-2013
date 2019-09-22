import java.util.ArrayList;

public class Course {
	private String cName;
	private ArrayList<String> students;
	
	public Course(String cNameIn, ArrayList<String> studentsIn) {
		cName = cNameIn;
		students = studentsIn;
	}
	
	public boolean equals(Object obj) {
		Boolean equal = false;
	if (obj == this) equal = true;
	if (obj == null || obj.getClass() != this.getClass()) equal =  false;
		Course otherCourse = (Course) obj;
	if (cName.equals(otherCourse.cName) && students.equals(otherCourse.students)) return true;
	return false;
}

	public String toString() {
		return "Course name: " + cName + "; GPA: " + students;
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
