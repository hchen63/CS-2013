import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

public class Test {

	@org.junit.Test
//	public void test() {
//		fail("Not yet implemented");		
//	}
	
	public void testSaveObjectToFile() {
		Student student[] = new Student[3];		
		student[0] = new Student ("Amy", 3.8);
		student[1] = new Student ("Hannah", 3.7);
		student[2] = new Student ("Mike", 3.6);
		ArrayList<Student> students = new ArrayList<>();
		for(int i = 0; i < 3; i++) {
			students.add(student[0]);
		}
		PersisterImplt<Student> pStudent = new PersisterImplt<Student>();		
		File f = new File("T.ser");
		pStudent.saveObjectToFile(f, student[0]);
		assert.equals(student[0],)
		
		
	}
	
	public void testStudent() {
		String nameIn = "Amy";
		Double gpaIn = 3.8;
		Student s = new Student(nameIn, gpaIn);
		assertNotNull(s);
		assertNotNull(s.toString());

	}
	
	public void testCourse() {
		String cNameIn = "CS 2013";
		ArrayList<String> studentsIn = new ArrayList<String>();
		studentsIn.add("Amy");
		studentsIn.add("Hannah");
		studentsIn.add("Mike");
		Course c = new Course(cNameIn, studentsIn);
		assertNotNull(c);
		assertNotNull(c.toString());

	}

}
