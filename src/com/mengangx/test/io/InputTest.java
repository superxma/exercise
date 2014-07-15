package com.mengangx.test.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=reader.readLine())!=null){
			String[] array = line.split(" ");
			for(int i=0; i<array.length; i++) {
				System.out.println(array[i]);
				try{
				    Integer.parseInt(array[i]);
				} catch (Exception e) {
					System.out.println(array[i] + " cannot be parsed as a Integer");
				}
			}
		}
		if (reader != null) {
		    reader.close();
		}
		
	}
	
	public static class Node<T> {
		T data;
		Node<T> next;
	}
	
	

}
