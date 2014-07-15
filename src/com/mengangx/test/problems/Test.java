package com.mengangx.test.problems;

public class Test {
    
    public static void main(String[] args) {
        String str = "  I   have   a nice  string  ";
        
        String [] words = str.split("\\s+");
        
        for(String word : words) {
            System.out.println("[" + word + "]");
        }
    }
}