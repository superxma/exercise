package com.mengangx.test.string;

public class StringManipulations {
	
	public static void main(String [] args) {
		String str= "what a beautiful day";
		
		System.out.println(str.charAt(3));
		System.out.println(str.substring(7, 16));
		
		Character.isLetterOrDigit(str.charAt(4));
		Character.isWhitespace(str.charAt(4));
		
	}
}