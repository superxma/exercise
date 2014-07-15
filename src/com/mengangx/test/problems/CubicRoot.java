package com.mengangx.test.problems;

public class CubicRoot {
	private double n;
	private double epsilon = 0.0000000001D;
	
	CubicRoot(double n) {
		this.n = n;
	}
	
	public double getCublicRoot() {
		double abs = n >= 0 ? n : -n;
		double l = 0;
		double r = abs;
		double median;
		double cubic;
		do {
			median = l + (r - l) / 2.0D;
			cubic = median * median * median;
			if (cubic <= abs && abs - cubic < epsilon) {
				break;
			} else if (cubic > abs) {
				r = median;
			} else {
				l = median;
			}
		} while (l < r);
		
		return n >= 0 ? median : -median; 	
	}
	
	public static void main(String[] args) {
		System.out.println(new CubicRoot(125.0).getCublicRoot());
	}
}