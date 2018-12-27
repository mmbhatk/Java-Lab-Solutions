import student.*;
import faculty.*;
import java.util.*;

public class details {
	public static void main(String[] args) {
		int USN, sid, snum, fnum;
		String dname, sname, designation, subjects;
		double m1, m2, m3, sgpa;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of students: ");
		snum = scan.nextInt();
		stud[] students = new stud[snum];
		
		for(int i = 1; i<=snum; i++) {
			System.out.println("\nEnter details of student " + i + ":");
			System.out.println("Student USN: ");
			USN = scan.nextInt();
			System.out.println("Department name: ");
			dname = scan.next();
			System.out.println("Subject 1 marks: ");
			m1 = scan.nextDouble();
			System.out.println("Subject 2 marks: ");
			m2 = scan.nextDouble();
			System.out.println("Subject 3 marks: ");
			m3 = scan.nextDouble();
			System.out.println("Student SGPA: ");
			sgpa = scan.nextDouble();
			students[i-1] = new stud(USN, dname, m1, m2, m3, sgpa);
		}
		
		System.out.println("\n\nEnter the number of faculties: ");
		fnum = scan.nextInt();
		fac[] faculty = new fac[fnum];
		
		for(int i = 1; i<=fnum; i++) {
			System.out.println("\nEnter details of faculty " + i + ":");
			System.out.println("\nStaff SID: ");
			sid = scan.nextInt();
			System.out.println("Staff name: ");
			sname = scan.next();
			System.out.println("Designation: ");
			designation = scan.next();
			System.out.println("Subjects: ");
			subjects = scan.nextLine();
			while(subjects.length()==0) subjects = scan.nextLine();
			faculty[i-1] = new fac(sid, sname, designation, subjects);
		}
		
		System.out.println("\n\nDetails of all the students: ");
		for(int i = 0; i<snum; i++) students[i].display();
		System.out.println("\n\nDetails of all the faculties: ");
		for(int i = 0; i<fnum; i++) faculty[i].display();
	}
}