package com.mengangx.test.leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        String result = Integer.toString(1);
        for(int i=2; i<=n; i++) {
            result = next(result);
        }
        return result;
    }
    
    public String next(String s) {
        char[] ch = s.toCharArray();
        StringBuilder out = new StringBuilder();
        int start = 0, end = 0;
        for(int i=1; i<ch.length; i++) {
            if(ch[i] == ch[start]){
                end++;
            } else {
                out.append(end-start+1);
                out.append(ch[start]);
                start = end = i;
            }
        }
        out.append(end-start+1);
        out.append(ch[start]);
        return out.toString();
    }
    
    public static void main(String[] args) {
        CountAndSay inst = new CountAndSay();
        for(int i=1; i<=10; i++){
            System.out.println(inst.countAndSay(i));
        }
    }
}