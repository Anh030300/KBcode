package main;

public class Objective {
	public static double getObjective(Individual indi) {
		int x = indi.value;
		return f(x);
	}
	
	public static double f(int x) {
		return (x*x - x + 1) * 1.0d / (x * Math.sin(x * Math.PI/ 180) + 6 * x * x *x + 2);
	}
}
