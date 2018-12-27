package q3a;

import java.util.*;

class NameNotCorrect extends Exception {
	public String toString() {
		return "NameNotCorrect Exception has occurred.";
	}
}

class AgeLimitException extends Exception {
	public String toString() {
		return "AgeLimitException has occurred.";
	}
}

class Employee {
	String name;
	int age;
	
	Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void display() {
		System.out.println("\nEmployee name: " + name);
		System.out.println("Employee age: " + age);
	}
}

public class q3a {
	public static void main(String[] args) {
		String name;
		int age;
		boolean isName = false;
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Enter name: ");
			name = scan.next();
			try {int x = Integer.parseInt(name);}
			catch(Exception e) {isName = true;}
			if(isName==false) throw new NameNotCorrect();
			
			System.out.println("\nEnter age: ");
			age = scan.nextInt();
			if(age>50) throw new AgeLimitException();
			
			Employee e = new Employee(name, age);
			e.display();
		}
		catch(NameNotCorrect e) {System.out.println(e);}
		catch(AgeLimitException e) {System.out.println(e);}
		catch(Exception e) {System.out.println(e);}
	}
}