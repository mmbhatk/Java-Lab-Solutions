package q13a;
import java.util.*;

abstract class Reservation {
	abstract public boolean reserve(int seats, String typeOfSeat);
	abstract public int getAvailableSeats();
}

class ReserveTrain extends Reservation {
	public boolean reserve(int seats, String typeOfSeat) {
		
	}
	public int getAvailableSeats() {
		
	}
}

class ReserveBus extends Reservation {
	public boolean reserve(int seats, String typeOfSeat) {
		
	}
	public int getAvailableSeats() {
		
	}
}

public class q13a {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ReserveTrain rt = new ReserveTrain();
		ReserveBus rb = new ReserveBus();
		
		int choice, nseats, rseats;
		String type;
		boolean status;
		
		while(true) {
			System.out.println("\n1) Reserve train");
			System.out.println("2) Reserve bus");
			System.out.println("Enter your choice:\n");
			choice = scan.nextInt();
			
			System.out.println("Enter type of seat(AC/Sleeper/General): ");
			type = scan.nextLine();
			while(type.length()==0) type = scan.nextLine();
			System.out.println("Enter number of seats to reserve: ");
			nseats = scan.nextInt();
			
			switch(choice) {
			case 1: System.out.println("\nEnter number of seats available: " + rt.availNum);
					status = rt.reserve(nseats, type)
					System.out.println("Reservation successful status: " + status);
					break;

			case 2: System.out.println("\nEnter number of seats available: " + rb.availNum);
					status = rt.reserve(nseats, type)
					System.out.println("Reservation successful status: " + status);
					break;
			
			default: System.exit(0);
			}
		}
	}
}