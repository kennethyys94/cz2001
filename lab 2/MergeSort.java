
import java.util.*;

public class MergeSort {
	public final static int SIZE = 8;
	private int[] array;
	
	// For key comparisons
	private static int numOfKeyComparisons = 0;
	
	public void printKeyComparisons() {
		System.out.println("Number of Key Comparisons: " + numOfKeyComparisons);
	}
	
	public MergeSort() {
		array = new int[SIZE];
	}
	
	// Data generator
	public void generateData(int generateInput) {
		switch (generateInput) {
			case 1:
				for (int i = 0; i < SIZE; i ++) {
					int value = (int)(Math.random()*((SIZE-1)+1))+1;
					array[i] = value;
				}
				break;
			case 2:
				for (int i =0; i < SIZE; i ++) {
					array[i] = i + 1;
				}
				break;
			case 3: 
				for (int i=0; i < SIZE; i ++) {
					array[i] = SIZE-i; 
				}
				break;
		}
	}
	
	public void printArray() {
		for (int i = 0; i < SIZE; i ++) {
			System.out.print(array[i] +" ");
		}
	}
	
	public void mergeMethod(int first, int last) {
		if (first < last) {
			int middle = (first+last)/2;
			mergeMethod(first, middle);
			mergeMethod(middle+1,last);
			merge(first,last);
		}
	}

	public void merge(int l, int r) {
		int m = (l+r)/2;
		int n1 = m - l + 1;
		int n2 = r - m;
		
		// Insert data to temp arrays
		int[] temp1 = new int[n1];
		int[] temp2 = new int[n2];
		
		for (int i = 0; i<n1; i++) {
			temp1[i] = array[l+i];
		}
		for (int j = 0; j <n2; j++) {
			temp2[j] = array[m+1+j];
		}
		
		// Merge the temp arrays
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i < n1 && j < n2 ) {
			System.out.println(temp1[i] + "VS" + temp2[j]);
			numOfKeyComparisons++;
			if (temp1[i] < temp2[j]) {
				array[k] = temp1[i];
				i++;
				k++;
			}
			else if (temp1[i] > temp2[j]) {
				array[k] = temp2[j];
				j ++;
				k ++;
			}
			else {
				array[k] = temp1[i];
				array[k+1] = temp2[j];
				i++;j++;k+=2;
			}
		}
		
		// If one is empty only
		while (i< n1) {
			array[k] = temp1[i];
			i++;k++;
		}
		while (j<n2) {
			array[k] = temp2[j];
			j++;k++;
		}
	}
}
