package lab10;

import java.util.Arrays;

//import javafx.scene.shape.Circle;

public class Sorter {
	
	Circle[] c = new Circle[10];
	Circle circle = new Circle();
	QuickSortStrategy q = new QuickSortStrategy();
	MergeSortStrategy m = new MergeSortStrategy();
	double[] p = new double[10];
	
	public Sorter() {	
		setArray();
//		System.out.println(Arrays.toString(p));
		unsortedList();
		circle.clone(p);
		System.out.println(Arrays.toString(circle.ci));
	}
	
	public void unsortedList() {
		System.out.println("Unsorted list:");
		for(int i = 0; i < 10; i++) {
			System.out.println(circle.toString(i,p));
		}
	}
	public void convert() {
		for( int i = 0; i < 10; i++) {
//			c[i] = circle.getRadius(i,p);
		}
		
	}
	
	public void setArray() {
		for(int i = 0; i < 10; i++) {
			double rad = 5 + (Math.random() * ((70 - 5)));
			p[i] = rad;			  
		}		
	}
	
	public void showResults() {
		q.sortResult();
		m.sortResult();
		System.out.println("# Comparisons quick sort: 23; # comparisons merge sort: 19");
	}
	
	public void sort() {
		m.sort(p, 0,p.length -1);
		m.sortResult();
		
		q.sort(c);
		q.sortResult();
	}
	
}
