package com.mengangx.test.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static class MaxComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	}
	
	public static void main(String [] arg) {
		Comparator<Integer> comparator = new MaxComparator();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, comparator);
		pq.add(new Integer(8));
		pq.add(new Integer(20));
		pq.add(new Integer(6));
		pq.add(new Integer(100));
		pq.add(new Integer(1));
		
		while (!pq.isEmpty()){
	        System.out.println(pq.remove());
		}
	}
	
}