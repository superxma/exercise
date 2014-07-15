package com.mengangx.test.problems;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelFibonacci {
	static ExecutorService executor = Executors.newCachedThreadPool();
	
	public static class Fibonacci implements Callable<BigInteger> {
		private int n;
		Fibonacci (Integer n) {
			this.n = n;
		}
		
	    public BigInteger calc () {
	    	if (n == 0) return BigInteger.ZERO;
	        if (n == 1) return BigInteger.ONE;
	        BigInteger x = BigInteger.ONE;
	        BigInteger y = BigInteger.ZERO;
	        BigInteger z;
	    	for (int i=2; i<=n; i++) {
	    		z = x;
	    		x = x.add(y);
	    		y = z;
	    	}
	    	return x;
	    }
	    
	    @Override
	    public BigInteger call() {
	    	return calc();
	    }
	}
	
	public static BigInteger calc(Integer n) throws Exception {
		if (n <= 0) return BigInteger.ZERO;
		try {
		    Future<BigInteger> left = executor.submit(new Fibonacci(n-1));
		    Future<BigInteger> right = executor.submit(new Fibonacci(n-2));
		    System.out.println("submit left and right");
		    return left.get().add(right.get());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String [] args) throws Exception {
		System.out.println(ParallelFibonacci.calc(30));
	}
}