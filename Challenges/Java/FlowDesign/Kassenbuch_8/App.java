package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {

	public static UI ui = new UI();

	public static void main(String[] args) {
		CMDParser cmdParser = new CMDParser();

		cmdParser.parseArguments(args, () -> add(args), () -> listEntries(new String[]{args[0], ("1." + args[1] + "." + args[2])}));

	}

	private static void listEntries(String[] arguments) {

		LocalDate date = LocalDate.parse(arguments[1], DateTimeFormatter.ofPattern("d.MM.yyyy"));

		Entry[] entries = getEntries();
		double carryOver = calculateCarryOver(entries, date);
		Booking[] bookings = BusinessLogic.calculateCashBalance(entries);

		bookings = Filterer.filterByDate(bookings, date);

		ui.printListing(bookings, carryOver, date);
	}

	private static double calculateCarryOver(Entry[] entries, LocalDate date) {

		Entry[] entriesBeforeMonth = Filterer.getAllTransactionsBefore(entries, date);
		double carryOver = BusinessLogic.sumAmounts(entriesBeforeMonth);

		return carryOver;
	}

	private static Entry[] getEntries() {
		return BusinessLogic.orderEntriesByDate(FileProvider.readEntriesFromFile());
	}

	private static void add(String[] arguments) {

		confirmEntry(arguments, () -> {
			Entry entry = BusinessLogic.createEntry(arguments);
			FileProvider.writeEntryToFile(entry);
			ui.printLine(entry);
		} , () -> {
		});
	}

	private static void confirmEntry(String[] arguments, IConfirm onConfirm, IDecline onDecline) {
		if (ui.readLine().equals("J")) {
			onConfirm.call();
		} else {
			onDecline.call();
		}
	}

}
