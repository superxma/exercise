package com.mengangx.test.problems;

/**
 * Class to match regex with . * $ ^
 * 
 * Still working on, wrong answer now
 * */

public class Regex2 {
    public static boolean match(char[] s, char[] p) {
        if(s == null || s.length == 0 && p.length > 0) {
            return false;
        }
        if(s[0] == '^') {
            return matchhere(s, 0, p, 1);
        } else {
            int si = 0;
            do{
                if(matchhere(s, si, p, 0)) {
                    return true;
                }
            } while(++si < s.length);
        }
        return false;
    }
    
    public static boolean matchhere(char[] s, int si, char[] p, int pi) {
        if(pi >= p.length) {
            return true;
        }

        if(pi + 1 < p.length && p[pi+1] == '*') {
            matchstar(s, si, p, pi+2, p[pi]);
        }
        
        if(p[pi] == '$' && pi == p.length - 1) {
            return si == s.length;
        }
        
        if(si < s.length && (p[pi] == '.' || p[pi] == s[si])) {
            return matchhere(s, si+1, p, pi+1);
        }
        return false;
    }
    
    public static boolean matchstar(char[] s, int si, char[] p, int pi, char c) {
        while(si < s.length && (s[si] == c || c == '.')){
            if(matchhere(s, si, p, pi)){
                return true;
            }
            si++;
        }

        return matchhere(s, si, p, pi);
    }
    
    
    public static void main(String[] args) {
        char[] s = new String("1111223").toCharArray();
        char[] p = new String("1*223").toCharArray();
        System.out.println(match(s, p));
    }
}