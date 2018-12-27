package q9a;
import java.util.*;

class Library {
	int acc_num;
	String title, author;
	Scanner scan = new Scanner(System.in);
	
	void input() {
		System.out.println("\nEnter account number: ");
		acc_num = scan.nextInt();
		
		System.out.println("Enter book title: ");
		title = scan.nextLine();
		while(title.length()==0) title = scan.nextLine();
		
		System.out.println("Enter book author: ");
		author = scan.nextLine();
		while(author.length()==0) author = scan.nextLine();
	}
	
	void compute() {
		System.out.println("\nEnter the number of days delayed: ");
		int days = scan.nextInt();
		System.out.println("\nFine charged: Rs." + (2*days));
	}
	
	void display() {
		System.out.println("\n" + acc_num + "\t" + title + "\t" + author);
	}
}

public class q9a {
	public static void main(String[] args) {
		Library l = new Library();
		l.input();
		l.compute();
		l.display();
	}
}