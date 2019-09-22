package persistence1;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

public class Test {

	@org.junit.Test
//	public void test() {
//		fail("Not yet implemented");		
//	}
	
	public void testStudentFile() {
		Student student[] = new Student[3];		
		student[0] = new Student ("Amy", 3.8);
		student[1] = new Student ("Hannah", 3.7);
		student[2] = new Student ("Mike", 3.6);
		ArrayList<Student> students = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			students.add(student[0]);
		}
		
		PersisterImplT<Student> pStudent = new PersisterImplT<Student>();		
		File f = new File("T.ser");
		pStudent.saveObjectToFile(f, student[0]);
		Student s = (Student) pStudent.readObjectFromFile(f);
		System.out.println(s);
		System.out.println(student[0]);
		assertEquals(student[0], s);
		
		ArrayList<Student> stu = (ArrayList<Student>) pStudent.readListFromFile(f);
		pStudent.saveListToFile(f, students);	
		assertEquals(students,stu);
		
		
	}
	
	public void testCourseFile() {
		Course course[] = new Course[3];		
		course[0] = new Course ("CS",null);
		course[1] = new Course ("English", null);
		course[2] = new Course ("Math", null);
		ArrayList<Course> courses = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			courses.add(course[0]);
		}
		
		PersisterImplT<Course> pCourse = new PersisterImplT<Course>();		
		File f = new File("T.ser");
		pCourse.saveObjectToFile(f, course[0]);
		Course c = (Course) pCourse.readObjectFromFile(f);
		System.out.println(c);
		System.out.println(course[0]);
		assertEquals(course[0], c);
		
		ArrayList<Course> cou = (ArrayList<Course>) pCourse.readListFromFile(f);
		pCourse.saveListToFile(f, courses);	
		assertEquals(courses,cou);
		
		
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
