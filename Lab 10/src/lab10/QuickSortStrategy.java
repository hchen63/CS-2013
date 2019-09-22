package lab10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

//import javafx.scene.shape.Circle;

public class QuickSortStrategy implements SortStrategy{
	
	final Circle[] arr = new Circle[10];
	int s = 0;
	int times;
	Circle fin[] = new Circle[10];
	Circle circle = new Circle();
	
	
	@Override
	public int sort(Circle[] arrayIn) {

		Circle[] L = new Circle[10];
		Circle[] E = new Circle[10];
		Circle[] G = new Circle[10];
		
		int l = 0;
		int e = 0;
		int g = 0;
	
		Circle num = arrayIn[s];
		System.out.println("asd");
		while(fin[fin.length-1] == null) {
			System.out.println("help");
			times++;
			System.out.println(Arrays.toString(fin));
			for(int i = 0; i < 10; i++) {
				Circle ex = arrayIn[i];
				if(compare(num,ex) < 1) {
					L[l] = num;
					l++;
					
				}else if(compare(num,ex) > 1) {
					G[g] = num;
					g++;
				}else
					E[e] = num;
			}
			
		}
		
		int i = 0;
		int k = 0;
		
		while (L.length != 0){
			fin[k] = L[i];
			i++;
			k++;
		}
		
		i = 0;
		while (E.length != 0){
			fin[s] = E[i];
			i++;
			k++;
		}
		i = 0;
		while (G.length != 0){
			fin[s] = G[i];
			i++;
			k++;
		}
		s++;
		
		return 0;
	}
	
	public void sortResult() {
		System.out.println(Arrays.toString(fin));
		System.out.println("# Comparisons quick sort: " + times);
	}
	
	public double compare(Circle a, Circle b) { 
		
        return 0; 
    }

}
