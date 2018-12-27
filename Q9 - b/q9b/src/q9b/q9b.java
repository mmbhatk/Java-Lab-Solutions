package q9b;

import java.sql.*;
import java.util.*;

public class q9b {
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "final";
		String username = "root";
		String password = "";
		
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url+dbName, username, password);
			con.setAutoCommit(false);
			
			do {
				System.out.println("\n1) Create new account");
				System.out.println("2) Deposit amount");
				System.out.println("3) Withdraw amount");
				System.out.println("4) Rollback");
				System.out.println("5) Commit");
				System.out.println("6) Display");
				System.out.println("Enter any other digit to exit.");
				
				
				int choice = scan.nextInt();
				String name;
				int acc, balance, amount;
				Statement stmt;
				PreparedStatement ps;
				ResultSet rs;
				
				switch(choice) {
				case 1: System.out.println("\nEnter name: ");
						name = scan.next();
						System.out.println("Enter account number: ");
						acc = scan.nextInt();
						System.out.println("Enter balance: ");
						balance = scan.nextInt();
						ps = con.prepareStatement("INSERT INTO BANK VALUES(?, ?, ?)");
						ps.setString(1, name);
						ps.setInt(2, acc);
						ps.setInt(3, balance);
						ps.executeUpdate();
						System.out.println("Inserted successfully.");
						break;
				
				case 2: System.out.println("\nEnter the account number: ");
						acc = scan.nextInt();
						System.out.println("Enter the amount to be deposited: ");
						amount = scan.nextInt();
						ps = con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE+? WHERE ACC=?");
						ps.setInt(1, amount);
						ps.setInt(2, acc);
						ps.executeUpdate();
						break;
						
				case 3: System.out.println("\nEnter the account number: ");
						acc = scan.nextInt();
						System.out.println("Enter the amount to be withdrawn: ");
						amount = scan.nextInt();
						ps = con.prepareStatement("UPDATE BANK SET BALANCE=BALANCE-? WHERE ACC=?");
						ps.setInt(1, amount);
						ps.setInt(2, acc);
						ps.executeUpdate();
						break;
						
				case 4: con.rollback();
						System.out.println("\nSuccessfully rollbacked.");
						break;
						
				case 5: con.commit();
						System.out.println("\nSuccessfully committed.");
						break;
						
				case 6: stmt = con.createStatement();
						rs = stmt.executeQuery("SELECT * FROM BANK");
						while(rs.next()) {
							System.out.println("\n\nName: " + rs.getString(1));
							System.out.println("Account number: " + rs.getInt(2));
							System.out.println("Balance: " + rs.getInt(3));
						}
						break;
				default: System.exit(0);
				}
			}while(true);
		}
		catch(Exception e) {e.printStackTrace();}
	}
}