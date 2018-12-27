
import java.util.*;

public class q11a {
	
	static int countDouble(String s) {
		int count = 0;
		for(int i = 1; i<s.length(); i++)
			if(s.charAt(i-1)==s.charAt(i)) count++;
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String s = scan.nextLine();
		while(s.length()==0) s = scan.nextLine();
		System.out.println("\nOriginal string: " + s);
		s = s.toUpperCase().replaceAll(" ", "");
		System.out.println("String after converting to uppercase: " + s);
		System.out.println("Number of double letter sequences: " + countDouble(s));
	}
}