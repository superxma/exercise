package com.mengangx.test.leetcode;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * */

public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();
        if (hlen < nlen) {
            return null;
        }
        
        for(int i=0; i<=hlen-nlen; i++) {
            boolean flag = true;
            for(int j=0; j<nlen; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                return haystack.substring(i);
            }
        }
        return null;
    }  
}