package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import grossmann.tim.FlowDesign.CSVTabellier_5;

public class UI {

	private static Scanner scanner = new Scanner(System.in);

	public String readLine() {

		System.out.print("Buchung wirklich anlegen? [Jn] ");
		String output = scanner.nextLine();

		return output;
	}

	public void printLine(Entry entry) {
		System.out.println("Buchung angelegt: " + entry.getDate().format(DateTimeFormatter.ofPattern("d.M.yyyy")) + ", "
				+ entry.getType() + ", " + entry.getAmount());
	}

	public void printListing(Booking[] bookings, double carryOver, LocalDate date) {
		
		System.out.println(date.getMonth() + " " + date.getYear());
		System.out.println("Übertrag: " + String.format("%.2f", carryOver));
		
		System.out.println();
		
		String csv = "Datum;Art;Bruttobetrag;Kassenbestand ";
		
		for(Booking booking : bookings) {
			csv += (booking.getDate().format(DateTimeFormatter.ofPattern("d.M.yyyy")) + ";" + booking.getType() + ";" + booking.getAmount() + ";" + String.format("%.2f", booking.getCashBalance()) + " "); 
		}
		
		CSVTabellier_5.main(csv.split(" "));
		
		System.out.println();
		
		System.out.println("Aktueller Kassenbestand: " + String.format("%.2f", bookings[bookings.length -1].getCashBalance()));
		
		
	}

}
