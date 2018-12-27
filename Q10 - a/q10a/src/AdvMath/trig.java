package AdvMath;

public class trig {
	public static void calcTrig(double x) {
		double x_rad = Math.toRadians(x);
		double y = Math.sin(x_rad) + Math.cos(x_rad) + Math.tan(x_rad);
		System.out.println("\ny = " + y);
	}
}