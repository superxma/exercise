package com.mengangx.test.leetcode;

public class Pow {
    public static double pow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (x == 1 || n == 0) {
            return 1;
        }
        //  check the sign of n
        boolean plus = n >= 0;
        n = plus ? n : -n;
        double r = 1;
        while (n > 0) {
            // if odd
            if (n % 2 != 0) {
                r *= x;
            }
            // reduce the exponential to its half
            n /= 2;
            // square the base
            x *= x;
        }
        // if n < 0, should return 1.0/x^n
        return plus ? r : 1.0 / r;
    }
}