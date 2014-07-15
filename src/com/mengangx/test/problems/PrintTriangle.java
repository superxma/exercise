package com.mengangx.test.problems;

/**
 * print a inverse triangle of *s without using
 * for or while
 * */

public class PrintTriangle {
    public static void printTriangle(int count) {
        printTriangle("", count);
    }
    
    public static String printTriangle(String prefix, int count) {
        if(count == 0 ) {
            System.out.println(prefix);
            return prefix;
        }
        
        String p = printTriangle(prefix + "*", count - 1);
        p = p.substring(0, p.length()-1);
        System.out.println(p);
        return p;
        
    }
    
    public static void main(String[] args) {
        printTriangle(5);
    }
}