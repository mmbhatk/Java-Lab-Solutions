package q13a;
import java.util.*;

abstract class Reservation {
	abstract public boolean reserve(int seats, String typeOfSeat);
	abstract public int getAvailableSeats();
}

class ReserveTrain extends Reservation {
	int seats_A, seats_B, seats_C;
	
	ReserveTrain(){
		seats_A = 5;
		seats_B = 5;
		seats_C = 5;
	}
	
	public boolean reserve(int seats, String type) {
		if(type.equals("A")) {
			if(seats_A >= seats) {seats_A -= seats; return true;}
			return false;
		}
		else if(type.equals("B")) {
			if(seats_B >= seats) {seats_B -= seats; return true;}
			return false;
		}
		else if(type.equals("C")) {
			if(seats_C >= seats) {seats_C -= seats; return true;}
			return false;
		}
		return false;
	}
	public int getAvailableSeats() {
		System.out.println("\nNumber of seats available: ");
		System.out.println("Type A: " + seats_A);
		System.out.println("Type B: " + seats_B);
		System.out.println("Type C: " + seats_C);
		return seats_A + seats_B + seats_C;
	}
}

class ReserveBus extends Reservation {
	int seats_A, seats_B;
	
	ReserveBus(){
		seats_A = 5;
		seats_B = 5;
	}
	
	public boolean reserve(int seats, String type) {
		if(type.equals("A")) {
			if(seats_A >= seats) {seats_A -= seats; return true;}
			return false;
		}
		else if(type.equals("B")) {
			if(seats_B >= seats) {seats_B -= seats; return true;}
			return false;
		}
		return false;
	}
	public int getAvailableSeats() {
		System.out.println("\nNumber of seats available: ");
		System.out.println("Type A: " + seats_A);
		System.out.println("Type B: " + seats_B);
		return seats_A + seats_B;
	}
}
public class q13a {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ReserveTrain rt = new ReserveTrain();
		ReserveBus rb = new ReserveBus();
		
		int choice, nseats, rseats, total;
		String type;
		boolean status;
		
		while(true) {
			System.out.println("\n1) Reserve train");
			System.out.println("2) Reserve bus");
			System.out.println("Enter your choice:\n");
			choice = scan.nextInt();
					
			switch(choice) {
			case 1: total = rt.getAvailableSeats();
					System.out.println("Total number of seats available in train: " + total);
					System.out.println("\nEnter number of seats to reserve in train: ");
					nseats = scan.nextInt();
					System.out.println("Enter type of seat(A/B/C): ");
					type = scan.nextLine();
					while(type.length()==0) type = scan.nextLine();
					status = rt.reserve(nseats, type);
					System.out.println("\nReservation successful status: " + status);
					break;

			case 2: total = rb.getAvailableSeats();
					System.out.println("Total number of seats available in bus: " + total);
					System.out.println("\nEnter number of seats to reserve in bus: ");
					nseats = scan.nextInt();
					System.out.println("Enter type of seat(A/B): ");
					type = scan.nextLine();
					while(type.length()==0) type = scan.nextLine();
					status = rb.reserve(nseats, type);
					System.out.println("\nReservation successful status: " + status);
					break;
			
			default: System.exit(0);
			}
		}
	}
}