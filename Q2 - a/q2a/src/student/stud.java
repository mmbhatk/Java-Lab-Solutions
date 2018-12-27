package student;

public class stud {
	int USN;
	String dname;
	double m1, m2, m3, sgpa;
	
	public stud(int USN, String dname, double m1, double m2, double m3, double sgpa) {
		this.USN = USN;
		this.dname = dname;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.sgpa = sgpa;
	}
	
	public void display() {
		System.out.println("\nStudent USN: " + USN);
		System.out.println("Department name: " + dname);
		System.out.println("Subject 1 marks: " + m1);
		System.out.println("Subject 2 marks: " + m2);
		System.out.println("Subject 3 marks: " + m3);
		System.out.println("Student SGPA: " + sgpa);
	}
}
