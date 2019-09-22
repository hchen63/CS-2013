package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Node<T extends Comparable<T>> implements BST<T>{
	
	private T data;
	int key;
	int leftBFT;
	int rightBFT;
	int leftIn;
	public T parent;
	public T value;
	public T left; // get index -1
	public T right;//get index +1
	public List<T> children = new ArrayList<>();
	public LinkedList<T> sort = new LinkedList<T>();
	

	public Node() {	
		
	}
	
	@Override
	public void add(T data) {
		Node newChild = new Node(data);
		if(children.isEmpty()) {
			parent = data;
		}
		
		children.add(key++,data);		
//		System.out.println("get" + get(data));	
	
		if(get(data) < 0) {			
			left = data;
		}else if(get(data) > 0)
			right = data;
	}
	
	public T getLast() {
		return sort.getLast();
	}
	public T getFirst() {
		return sort.getFirst();
	}
	
	public T getData(int n) {
		return sort.get(n);
	}
	
	public Node(T data) {
	        this.data = data;
	}
	
	public int get(T data) {		
		return data.compareTo(parent);	
	}
	
	public void sort() {
		Collections.sort(children);
		for(int i=0; i<children.size(); i++)
		    System.out.println(children.get(i));
		sort.addAll(children);
		System.out.println("Sort "+ sort);
	}
	
	public void removeObj(T n) {		
		children.remove(n);
	}
	
	public int sizeTree() {
		return children.size();
		
	}
	public void showBFTraversal(T n) {
		if(n == null) {
//			System.out.println("end");
			return; 
		}
		System.out.println(n);
		int par = children.indexOf(parent);
		int num = children.indexOf(n);		
//		System.out.println(num);
		if(leftBFT + rightBFT != 0) {	
//			System.out.println(children.size());
//			System.out.println(rightBFT);
			if(children.size() != rightBFT) {
				right = getData(rightBFT);
//				System.out.println(right);
				rightBFT = num + 1;
//				System.out.println(rightBFT);
				showBFTraversal(right); 
			}
		}
		leftBFT = num - 1;		
		rightBFT = num + 1;
		
//		System.out.println(children.size());
//		System.out.println(rightBFT);
		
		left = getData(leftBFT);
//		right = getData(rightBFT);
		
		if(leftBFT >= 0 ) {
//			System.out.println(left);
			showBFTraversal(left);
		}
		System.out.println("poop");
//		if(children.size() != rightBFT) {
//			System.out.println(right);
//			showBFTraversal(right); 
//		}
	}
	
	@Override
	public void showAll(T n) {
		if(n == null) {
//			System.out.println("end");
			return; 
		}
		System.out.println("Inoder: " + children);
/*		if(value == left) {
			System.out.println(children.indexOf(n) + " " + n); 
			showAll(right); 
		}
		value = left;
		showAll(left); 
*/
	}

}