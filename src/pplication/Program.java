package pplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number:");
		int number = sc.nextInt();

		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy):");
		Date checKin = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());

		// after testa se uma data e depois da outra
		// a leitura e se a data checkOut não e depois de checKin
		if (!checkOut.after(checKin)) {
			System.out.println("Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checKin, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy):");
			checKin = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checKin.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checKin)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				reservation.upDtaedates(checKin, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}

	}

}
