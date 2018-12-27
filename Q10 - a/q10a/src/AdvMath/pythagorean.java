package AdvMath;

public class pythagorean {
	public static void calcTriplets(int limit) {
		int a, b, c = 0, m = 2;
		while(c < limit) {
			for(int n = 1; n < m; n++) {
				a = m * m - n * n;
				b = 2 * m * n;
				c = m * m + n * n;
				if(c > limit) break;
				System.out.println(a + "\t" + b + "\t" + c);
			}
			m++;
		}
	}
}