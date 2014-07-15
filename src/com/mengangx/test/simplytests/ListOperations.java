package com.mengangx.test.simplytests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListOperations {
	
	public static void main (String [] args) {
		List<String> strList = new ArrayList<String>();
		strList.add("what a beautiful girl!");
		System.out.println(strList.get(0));
		
		List<String> immuList = Collections.unmodifiableList(strList);
		
		try{
			immuList.add("String can never be added.");
		} catch (Exception e) {
			System.out.println(e.getClass());
		}
		
		//play with iterator
		Iterator<String> it = strList.iterator();
		
		for (;it.hasNext();) {
			System.out.println(it.next());
		}
		
		ListIterator<String> lsIt = strList.listIterator();
		System.out.println(lsIt.next());
		System.out.println(lsIt.previous());
		
		strList = Arrays.asList(new String[1]);
		System.out.println(strList.size());
		System.out.println(strList.get(0));
		
	}
}