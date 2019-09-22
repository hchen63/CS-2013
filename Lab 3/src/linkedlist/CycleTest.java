package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class CycleTest {

	@Test
	public void noNodes() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		assertEquals(l.size(), 0);
		assertNotNull(l);
	}
	
	@Test
	public void listNoCycle() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		assertEquals(l.size(), 2);	
		assertNotNull(l);
	}
	
	@Test
	public void oneNodeReference() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		l.isCycle(l);
		assertNotNull(l);
	}
	
	@Test
	public void oddLengthCycle() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		String testString3 = "Jersey Devil";
		l.add(testString3);
		l.isCycle(l);
		assertEquals(l.size(), 3);
		assertNotNull(l);
		
		
	}
	
	@Test
	public void evenLengthCycle() {
		SinglyLinkedList<String> l = new SinglyLinkedList<String>();
		String testString = "Godzilla";
		l.add(testString);
		String testString2 = "Mothra";
		l.add(testString2);
		l.isCycle(l);
		assertEquals(l.size(), 2);
		assertNotNull(l);
		
	}
}
