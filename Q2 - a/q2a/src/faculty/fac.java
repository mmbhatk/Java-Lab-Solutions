package faculty;

public class fac {
	int sid;
	String sname, designation, subjects;
	
	public fac(int sid, String sname, String designation, String subjects) {
		this.sid = sid;
		this.sname = sname;
		this.designation = designation;
		this.subjects = subjects;
	}
	
	public void display() {
		System.out.println("\nStaff SID: " + sid);
		System.out.println("Staff name: " + sname);
		System.out.println("Designation: " + designation);
		System.out.println("Subjects: " + subjects);
	}
}