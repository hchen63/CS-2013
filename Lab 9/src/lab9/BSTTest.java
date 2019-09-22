package lab9;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import lab9.BSTTest.T;

public class BSTTest {

	public enum T {
		A(1), B(2), Bee(3), data(4), O(5), Z(6);
		public final int value;
		private T(int value) {
	        this.value = value;
	    }
		public int getValue() {
	        return this.value;
	    }
	}
	
	
	
	@Test
	public void test() {

		Node<T> nod = new Node<T>();
		
		
		T o = T.valueOf("O");
		T a = T.valueOf("A");		
		T b = T.valueOf("B");
		T bee = T.valueOf("Bee");		
		T z = T.valueOf("Z");
		T data = T.valueOf("data");
		
		nod.add(o);
		nod.add(a);				
		nod.add(b);
		nod.add(bee);
		nod.add(z);
		nod.add(data);		
		
		System.out.println("Current size: " + nod.sizeTree() + ", Current Unsorted List " + nod.children);
		
		System.out.println("Remove: " + data);
		nod.removeObj(data);
		
		System.out.println("Size after removal: " + nod.sizeTree());
		
		nod.sort();
		nod.left = nod.getFirst();
		nod.right = nod.getLast();
		System.out.println("Children " + nod.children);
		System.out.println("Parent " +nod.parent);
		System.out.println("Left " + nod.left);
		System.out.println("Right " + nod.right);
		
		nod.showAll(a);
//		nod.showBFTraversal(nod.parent);
	}
	
}