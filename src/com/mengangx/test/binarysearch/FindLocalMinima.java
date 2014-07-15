package com.mengangx.test.binarysearch;

/*
 * Find local minima in an unsorted integer array 
 * without duplicates. Assume a[-1] and a[length] 
 * are +INF.  
 * */

public class FindLocalMinima {
	public static int findLocalMinima(int[]a) {
		if (a == null || a.length == 0) {
			return -1;
		}
	    int l = 0;
	    int r = a.length - 1;
	    int m;
	    
	    while (r - l > 1) {
	    	m = l + (r-l) / 2;
	    	if(a[m] < a[m+1]) {
	    		r = m;
	    	} else {
	    		l = m + 1;
	    	}
	    }    
	    return a[l] < a[r] ? l : r;
	}
	
	public static void main(String[] args) {
		int [] a = new int[]{3,5,6,4,2,7,8,1};
		int index = findLocalMinima(a);
		System.out.println(a[index]);
	}
	
}