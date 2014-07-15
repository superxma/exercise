package com.mengangx.test.simplytests;


public class HelloWorld {
	
    public static void nextPermutation(char [] ch, int n) {
    	int i;
        for(i = n-1; i>0; i--) {
            if(ch[i] > ch[i - 1]) {
                break;
            }
        }
        int index = i - 1;
        int end = n - 1;
        char temp;
        while(i < end) {
            temp = ch[i];
            ch[i] = ch[end];
            ch[end] = temp;
            ++i;
            --end;
        }
        if (index >= 0) {
            for(int j = index + 1; j < n ; j++) {
                if(ch[index] < ch[j]) {
                    temp = ch[index];
                    ch[index] = ch[j];
                    ch[j] = temp;
                    break;
                }
            }
        }
    }
	
	public static void main (String [] args) {
		char [] A = new char[] {'1','4','5','3','2'};
		System.out.println("hello");
		nextPermutation(A, 5);
		StringBuilder builder = new StringBuilder();
        for(int i = 1; i<=5; i++) {
            builder.append(i);
        }
        char[] str = builder.toString().toCharArray();
        for (char c : str) {
        	System.out.println(c);
        }
        
	}
}