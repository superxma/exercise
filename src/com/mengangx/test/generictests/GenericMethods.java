package com.mengangx.test.generictests;

import java.util.Arrays;
import java.util.List;

public class GenericMethods {
	public interface Printable<T extends List<? extends Object>> {
		void print(T t);
	}
	
	public static class PrintStrList implements Printable<List<String>> {
		@Override
		public void print(List<String> list) {
			for (String str : list) {
				System.out.println(str);
			}
		}
		
		private PrintStrList() {};
		
		public static PrintStrList newInstance() {
			return new PrintStrList();
		}
	}
	
	public static class Node<T, V> {
		
		@SuppressWarnings("unchecked")
		public V convert (T t) {
			if ((Node.class.getTypeParameters())[1].getClass().isAssignableFrom(t.getClass())) {
				return (V)t;
			}
			return null;
		}
		
	}
	
	public static void main(String [] args) {
		PrintStrList print = PrintStrList.newInstance();
		List<String> list = Arrays.asList("a", "b", "c");
		print.print(list);
		
		Node<String, Object> convertibleNode = new Node<String, Object>();
		System.out.println(convertibleNode.convert("a bird"));
		
		
	}
}