package com.mengangx.test.problems;

import java.io.IOException;

/*
 * process string like 3+3*5 and return the result
 * only operators are + - * /
 * */

public class OperationStringToInt {
	public static int split(String str) {
		System.out.println("str: " + str);
		int len = str.length();
		if (len == 0) {
			return -1;
		}
		int hi = -1;
		int li = -1;
		for(int i=0; i<len; i++) {
			if(str.charAt(i) == '*' || str.charAt(i) == '/') {
				hi = i;
			} else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				li = i;
			}
		}
	    return li == -1 ? (hi == -1 ? -1 : hi) : li;
	}
	
	public static int toInt(String str) throws IOException {
		int len = str.length();
		if(len == 0) {
			return 0;
		} else if (len == 1) {
			return Integer.parseInt(str);
		}
		
		int index = split(str);
		if (index == -1) {
			return Integer.parseInt(str);
		} 
	    char op = str.charAt(index);
		if (op == '+') {
			return toInt(str.substring(0, index)) + toInt(str.substring(index+1));
		} else if (op == '-') {
			return toInt(str.substring(0, index)) - toInt(str.substring(index+1));
		} else if (op == '*') {
			return toInt(str.substring(0, index)) * toInt(str.substring(index+1));
		} else if (op == '/') {
			return toInt(str.substring(0, index)) / toInt(str.substring(index+1));
		} else {
			throw new IOException("invalid operator");
		}

	}
	
	public static void main(String[] args) throws IOException {
		String ex = "3+3*5/2";
		System.out.println(toInt(ex));
	}
	
}