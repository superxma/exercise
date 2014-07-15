package com.mengangx.test.problems;


/*
 * Generate all permutations of a String
 * String can have duplicate letters
 * */
public class Permutation {
    /*
     * Generate next permutaion of the current string.
     * If all letters in the current string are in 
     * no increasing order.
     * */
    public static String nextPermutation(String str) {
        if(str == null || str.length() == 0) {
            return str;
        }
        int len = str.length();
        int i;
        for(i=len-1; i>0; i--) {
            if(str.charAt(i) > str.charAt(i-1)) {
                break;
            }
        }
        
        char [] chars = str.toCharArray();        
        //reverse the str from i to len -1
        //after reverse, the letters will be
        //in non-decreasing order

        char tmp;
        int start = i, end = len - 1;
        while(start < end) {
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        
        if(i == 0) { //letters in str are in non-increasing order
            return String.valueOf(chars);
        }
        
        //swap char at index i-1 with the smallest letter in sequence
        //from i to len-1 that is larger than char at index i-1
        for(int j=i; j<len; j++) {
            if(chars[j] > chars[i-1]) {
                tmp = chars[i-1];
                chars[i-1] = chars[j];
                chars[j] = tmp;
                break;
            }
        }
        return String.valueOf(chars);
    }
    
    public static void main(String[] args) {
        String str = "31524";
        String next = str;
        System.out.println(str);
        int count = 1;
        while(!(next = nextPermutation(next)).equals(str)) {
            System.out.println(next);
            count++;
        }
        System.out.println("total number of permutations: " + count);
    }
}