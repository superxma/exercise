package com.mengangx.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * */

public class RomantoInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] ch = s.toCharArray();
        int sum = 0;
        int i = 0;
        while(i< ch.length - 1) {
            if(map.get(ch[i]) >= map.get(ch[i + 1])) {
                sum += map.get(ch[i]);
                ++i;
            } else {
                sum += map.get(ch[i+1]) - map.get(ch[i]);
                i = i + 2;
            }
        }
        if (i == ch.length - 1) {
            sum += map.get(ch[i]);
        }
        return sum;
    }    
    
}