package lab8;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import lab8.BSTTest.T;

public class BSTTest {

	public enum T {
		A, B, data, O, Z,;	
	}
	
	@Test
	public void test() {

		Node<T> nod = new Node<T>();
		
		T a = T.A;
		T b = T.B;
		T o = T.O;
		T z = T.Z;	
		T data = T.data;
		
		nod.add(o);
		nod.add(a);
		nod.add(b);
		nod.add(z);
		nod.add(data);
		
//		nod.showAll(n);
				
		System.out.println("Children " + nod.children);
		System.out.println("Parent " +nod.parent);
		System.out.println("Left " + nod.left);
		System.out.println("Right " + nod.right);
	}
	
}
