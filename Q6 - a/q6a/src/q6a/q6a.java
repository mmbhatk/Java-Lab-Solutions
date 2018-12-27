package q6a;

import java.util.*;

class AgeOutOfRangeException extends Exception {
	public String toString() {
		return "\nApplication rejected. Age is greater than 25.";
	}
}

class LowCgpaException extends Exception {
	public String toString() {
		return "\nApplication rejected. CGPA is lesser than 8.";
	}
}

public class q6a {
	public static void main(String[] args) {
		int age;
		float cgpa;
		boolean accepted = true;
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Enter age: ");
			age = scan.nextInt();
			if(age>25) throw new AgeOutOfRangeException();
			
			try {
				System.out.println("Enter CGPA: ");
				cgpa = scan.nextFloat();
				if(cgpa<8) throw new LowCgpaException();
			}
			catch(LowCgpaException e) {
				System.out.println(e);
				accepted = false;
			}
			
		}
		catch(AgeOutOfRangeException e) {
			System.out.println(e);
			accepted = false;
		}
		catch(Exception e) {
			System.out.println(e);
			accepted = false;
		}
		if(accepted==true) System.out.println("\nYour application is accepted and is under study.");
	}
}