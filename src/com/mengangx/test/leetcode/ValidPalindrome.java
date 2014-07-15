package com.mengangx.test.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;    
        }
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        int l = 0;
        int r = len - 1;
        while (l < r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                ++l;
            } else if (!Character.isLetterOrDigit(s.charAt(r))){
                --r;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                ++l;
                --r;
            }
        }
        return true;

    }
}