package com.mengangx.test.leetcode;

public class ReverseWords {
    public static String reverseWords(String s) {
    	String input = s.trim();
    	String[] words = input.split(" ");
    	String output = "";
    	for (int i=words.length-1; i>=0; i--){
            if(words[i].length() != 0){
    		    output = output.concat(words[i].trim());
    		    output = output.concat(" ");
            }
    	} 	
		return output.trim();
    }
    
    public static void main(String[] args) {
    	String input= " A string  with trailing    spaces ";
    	System.out.println(reverseWords(input));
    }
}