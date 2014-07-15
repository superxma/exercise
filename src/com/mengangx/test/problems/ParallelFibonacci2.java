package com.mengangx.test.problems;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelFibonacci2 extends RecursiveTask<BigInteger> {   
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int n;
    private static final int THRESHOLD = 10;
    private BigInteger result;

    ParallelFibonacci2 (int n) {
        this.n = n;
    }
    
    public BigInteger calc (int num) {
        if (num == 0) return BigInteger.ZERO;
        if (num == 1) return BigInteger.ONE;
        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.ZERO;
        BigInteger z;
        for (int i=2; i<=num; i++) {
            z = x;
            x = x.add(y);
            y = z;
        }
        return x;
    }
    
    public BigInteger compute() {
        if(n <= THRESHOLD) {
            result =  calc(n);
        } else{
            ParallelFibonacci2 f1 = new ParallelFibonacci2(n-1);
            f1.fork();
            ParallelFibonacci2 f2 = new ParallelFibonacci2(n-2);
            result = f2.compute().add(f1.join());
        }     
        return result;
    }
    
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("No of processors: " + processors);
        
        ParallelFibonacci2 task = new ParallelFibonacci2(50);
        ForkJoinPool pool = new ForkJoinPool(processors);
        System.out.println("After creating pool");
        BigInteger result = pool.invoke(task);
        System.out.println("Computed Result: " + result);
    }   
}