package q1a;

import java.util.*;

class myClass implements exam {
	int sno, attendance;
	String sname, sclass;
	float perc;
	
	public myClass(int sno, String sname, String sclass, int attendance) {
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.attendance = attendance;
	}
	
	public void getValue() {
		System.out.println("\nStudent number: " + sno);
		System.out.println("Student name: " + sname);
		System.out.println("Student class: " + sclass);
		System.out.println("Attendance: " + attendance);
	}
	
	public float getAttendance() {
		return perc;
	}
	
	public void calcAttendance() {
		perc = ((float)attendance/50)*100;
	}
	
	public boolean eligible() {
		if(perc>=85) return true;
		return false;
	}
}

public class q1a {
	public static void main(String[] args) {
		int sno, attendance, n;
		String sname, sclass;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of students: ");
		n = scan.nextInt();
		
		myClass[] stud = new myClass[n];
		
		for(int i = 1; i<=n; i++) {
			System.out.println("\nEnter the details of student " + i + ": ");
			System.out.println("\nStudent number: ");
			sno = scan.nextInt();
			System.out.println("Student name: ");
			sname = scan.next();
			System.out.println("Student class: ");
			sclass = scan.next();
			System.out.println("Attendance: ");
			attendance = scan.nextInt();
			stud[i-1] = new myClass(sno, sname, sclass, attendance);
		}
		
		System.out.println("\n\nDisplaying the details of all the students: ");
		
		for(int i = 0; i<n; i++) {
			stud[i].getValue();
			stud[i].calcAttendance();
			System.out.println("Attendance percentage: " + stud[i].getAttendance());
			if(stud[i].eligible()==true) System.out.println("ELIGIBLE.");
			else System.out.println("NOT ELIGIBLE.");
		}
	}
}