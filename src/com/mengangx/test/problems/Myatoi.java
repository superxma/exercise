package com.mengangx.test.problems;

import java.io.IOException;

public class Myatoi {
    public static int atoi(String str) throws IOException {
        if(!str.matches("^[+-]?\\d+$")) {
            throw new IOException("Input string is invalid");
        }
        return Integer.parseInt(str);
    }
    
    public static void main(String[] args) throws IOException {
        //System.out.println(atoi("+123456781234567812345678"));
        System.out.println(Integer.toBinaryString(-Integer.MAX_VALUE));
        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(-1));
    }
}