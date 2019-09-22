package lab11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

public class CityNodeMergeSorter {
	Object[] fin = new Object[100];
	int times;
	
	public List<CityNode> getSortedList(Set<CityNode> nodes){
		List<CityNode> list = nodes.stream().collect(Collectors.toList());
		System.out.println(list);
		CityNode[] a = (CityNode[]) list.toArray();
		sort(a,0, a.length -1);
		List<CityNode> fina = Arrays.asList(a);
		
		return fina;
	}
	
	public void merge(Object[] arr, int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        Object L[] = new Object [n1]; 
        Object R[] = new Object [n2]; 
  
        for (int i=0; i<n1; ++i) { 
            L[i] = arr[l + i]; 
        }
        for (int j=0; j<n2; ++j) { 
            R[j] = arr[m + 1+ j]; 
        }
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) { 
        	Object a = L[i];
        	Object b = R[j];
            if (((CityNode) a).compareTo((CityNode) b) < 0) { 
                arr[k] = L[i]; 
                i++; 
            } else{ 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2){ 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
        fin = arr.clone();
    } 
  
    public void sort(Object[] a, int l, int r) { 
        if (l < r) {  
            int m = (l+r)/2; 
            times++;
            sort(a, l, m); 
            times++;
            sort(a , m+1, r); 

            merge(a, l, m, r); 
        } 
    } 

}
