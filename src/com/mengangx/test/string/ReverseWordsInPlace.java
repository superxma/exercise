package com.mengangx.test.string;

public class ReverseWordsInPlace {
	public static void reverseString(char[] str, int start, int end) {
		if (start >= end || end >= str.length) {
			return;
		}
		char tmp;
		while (start < end) {
			tmp = str[start];
			str[start] = str[end];
			str[end] = tmp;
			++start;
			--end;
		}
		return;
	}
	//str can have trailing spaces
	public static void reverseWords(char[] str) {
		if (str == null) {
			return;
		}
		int len = str.length;
		reverseString(str, 0, len-1);
		
		//reverse each word in string
		int i =0, j, start, end;
		while (Character.isWhitespace(str[i])) {
			++i;
		}
		start = end = i;
		for (j=i+1; j<len; j++) {
			if (!Character.isWhitespace(str[j])) {
				++end;
				if(Character.isWhitespace(str[start])) {
					++start;
				}
			} else {
				reverseString(str, start, end);
				start = end = j;
			}
		}
		if (!Character.isWhitespace(str[len-1])) {
			reverseString(str, start, end);
		}
		return;
	}
	
	public static void main(String[] args) {
		String str = "We have   a little    dog  ";
		char [] array = str.toCharArray();
		char [] test = str.toCharArray();
		reverseString(test, 0 , test.length-1);
		reverseWords(array);
		System.out.println(test);
		System.out.println(array);
	}
}