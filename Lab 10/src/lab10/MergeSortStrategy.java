package lab10;

import java.util.Arrays;

public class MergeSortStrategy implements SortStrategy{

	double fin[] = new double[10];
	int times;
	Circle c = new Circle();
//	@Override
	
	public void merge(double arr[], int l, int m, int r) { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        double L[] = new double [n1]; 
        double R[] = new double [n2]; 
  
        for (int i=0; i<n1; ++i) { 
            L[i] = arr[l + i]; 
        }
        for (int j=0; j<n2; ++j) { 
            R[j] = arr[m + 1+ j]; 
        }
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i] <= R[j]) { 
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
  
    public void sort(double arr[], int l, int r) { 
        if (l < r) {  
            int m = (l+r)/2; 
            times++;
            sort(arr, l, m); 
            times++;
            sort(arr , m+1, r); 

            merge(arr, l, m, r); 
        } 
    } 
	public void sortResult() {
		
		System.out.println("Sorted List:");
		for( int i = 0; i < 10; i++) {
			System.out.println(c.toString(i, fin));
		}
		System.out.println("# comparisons merge sort:" + times);
		
	}

	@Override
	public int sort(Circle[] arrayIn) {
		Arrays.sort(arrayIn);
		return 0;
	}


	

}
