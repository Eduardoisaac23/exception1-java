package pplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import modelexception.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
		System.out.print("Room number:");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checKin = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());

		// after testa se uma data e depois da outra
		// a leitura e se a data checkOut não e depois de checKin
		
		Reservation reservation = new Reservation(number, checKin, checkOut);
		System.out.println("Reservation: " + reservation);

		System.out.println("Enter data to update the reservation:");
		System.out.print("Check-in date (dd/MM/yyyy):");
		checKin = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy):");
		checkOut = sdf.parse(sc.next());

		reservation.upDtaedates(checKin, checkOut);
	    System.out.println("Reservation: " + reservation);

		}
		catch (ParseException e) {
			System.out.println("Invalid date format	");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
