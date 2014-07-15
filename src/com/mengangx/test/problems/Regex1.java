package com.mengangx.test.problems;

/**
 * Write method to match regex with + 
 *
 */

public class Regex1 {
    public static boolean match(char[] str, char[] p) {

        for(int i=0; i<str.length; i++) {
            if(match(str, i, p, 0)){
                return true;
            }
        }
        return false;
    }
    //exact match
    public static boolean match(char[] str, int si, char[] p, int pi) {
        if(pi >= p.length) {
            return true;
        }
        
        if(si >= str.length) {
            return false;
        }
        
        if(str[si] != p[pi]) {
            return false;
        }
        else{
            if(pi + 1 < p.length && p[pi + 1] == '+') {
                while(si < str.length && str[si] == p[pi]) {
                    si++;
                }
                return match(str, si, p, pi+2);
            } else {
                return match(str, si, p, pi+1);
            }
            
        }
    }
    
    public static void main(String[] args) {
        char[] s = new String("1233334555567").toCharArray();
        char[] p = new String("1+2+3+4+5+6+7+").toCharArray();
        System.out.println(match(s, p));
    }
}