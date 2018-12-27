import AdvMath.*;
import java.util.*;

public class q10a {
	public static void main(String[] args) {
		int limit;
		float val;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\nEnter the value of x: ");
		val = scan.nextFloat();
		trig obj = new trig();
		trig.calcTrig(val);
		
		System.out.println("\nEnter limit: ");
		limit = scan.nextInt();
		pythagorean obj2 = new pythagorean();
		obj2.calcTriplets(limit);
	}
}