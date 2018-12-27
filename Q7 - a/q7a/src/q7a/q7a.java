package q7a;

import java.util.*;

class Record {
	String[] name = new String[5];
	int[] rank = new int[5];
	Scanner scan;
	
	Record() {
		scan = new Scanner(System.in);
		for(int i = 0; i<5; i++) {
			name[i] = "";
			rank[i] = 0;
		}
	}
	
	void readValues() {
		for(int i = 0; i<5; i++) {
			System.out.println("\nEnter details of student " + (i+1) + ":");
			System.out.println("Name: ");
			name[i] = scan.next();
			System.out.println("Rank: ");
			rank[i] = scan.nextInt();
		}
	}
	
	void display() {
		for(int i = 0; i<5; i++) {
			System.out.println("\nDetails of student " + (i+1) + ":");
			System.out.println("Name: " + name[i]);
			System.out.println("Rank: " + rank[i]);
		}
	}
}

class Rank extends Record {
	int index;
	Rank() {
		super();
		index = 0;
	}
	
	void highest() {
		for(int i = 1; i<5; i++)
			if(rank[i]<rank[index]) index = i;
	}
	
	void display() {
		super.display();
		System.out.println("\n\nHighest rank: " + name[index]);
	}
}

public class q7a {
	public static void main(String[] args) {
		Rank r = new Rank();
		r.readValues();
		r.highest();
		r.display();
	}
}