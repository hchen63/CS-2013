package persistence2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import persistence2.Course;
import persistence2.PersisterImplT;
import persistence2.Student;

public class Test {

	@org.junit.Test
//	public void test() {
//		fail("Not yet implemented");		
//	}
	
	public void testStudentFile() {
		Student student[] = new Student[3];		
		student[0] = new Student ("Amy","Jones", 3.8);
		student[1] = new Student ("Hannah","Chen", 3.7);
		student[2] = new Student ("Mike","Lam", 3.6);
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
		course[0] = new Course ("CS",null, null);
		course[1] = new Course ("English", null, null);
		course[2] = new Course ("Math", null, null);
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
		String firstNameIn = "Amy";
		String lastNameIn = "Jones";
		Double gpaIn = 3.8;
		Student s = new Student(firstNameIn, lastNameIn, gpaIn);
		System.out.println("hi");
		assertNotNull(s);
		assertNotNull(s.toString());

	}
	
	public void testCourse() {
		String cNameIn = "CS 2013";
		ArrayList<String> studentsIn = new ArrayList<String>();
		studentsIn.add("Amy");
		studentsIn.add("Hannah");
		studentsIn.add("Mike");
		
		double[] gpaIn = new double[] {3.5, 2.56, 4.3};

		Course c = new Course(cNameIn, studentsIn, gpaIn);
		System.out.println(c.toString());
		System.out.println(c.meanGpa(gpaIn));
		assertNotNull(c);
		assertNotNull(c.toString());
		assertNotNull(c.meanGpa(gpaIn));

	}


}
