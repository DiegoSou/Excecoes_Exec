package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = scan.nextInt();
			System.out.print("Holder: "); 
			scan.next();
			String holder = scan.next();
			System.out.print("Initial Balance: ");
			double balance = scan.nextDouble();
			System.out.print("Withdraw Limit: ");
			double withdrawLimit = scan.nextDouble();
			
			Account ac = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double withdraw = scan.nextDouble();
			
			ac.withdraw(withdraw);
			System.out.println(ac);
		}
		catch (DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}
		
		
		scan.close();
	}

}
