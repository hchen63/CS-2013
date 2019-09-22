package lab8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node<T extends Comparable<T>> implements BST<T>{
	
	private T data;
	int key;	
	public T parent;
	public T left; // get index -1
	public T right; //get index +1
	public List<T> children = new ArrayList<>();

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
	
	public Node(T data) {
	        this.data = data;
	}
	
	public int get(T data) {			
		return data.compareTo(parent);	
	}
	
	@Override
	public void showAll(T n) {
		if(n == null) {
//			System.out.println("end");
			return; 
		}
		
		
		System.out.println(n);
		showAll(left); 

		System.out.println(key + " "); 
		showAll(right); 
	}

}
