package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BusinessLogic {

	public static Entry createEntry(String[] arguments) {
		Entry entry = new Entry(LocalDate.parse(arguments[1], DateTimeFormatter.ofPattern("d.M.yyyy")), arguments[2],
				Double.parseDouble(arguments[3].replace(",", ".")));
		return entry;
	}

	public static Entry[] orderEntriesByDate(Entry[] readEntriesFromFile) {

		List<Entry> entries = Arrays.asList(readEntriesFromFile);

		Collections.sort(entries, (a, b) -> {
			return a.getDate().compareTo(b.getDate());
		});

		return (Entry[]) entries.toArray();
	}

	public static double sumAmounts(Entry[] entriesBeforeMonth) {

		double sum = 0;

		for (Entry entry : entriesBeforeMonth) {
			sum += entry.getAmount();
		}

		return sum;
	}

	public static Booking[] calculateCashBalance(Entry[] entries) {

		Booking[] bookings = new Booking[entries.length];

		double currentVal = 0;

		for (int i = 0; i < entries.length; i++) {

			currentVal += entries[i].getAmount();
			bookings[i] = new Booking(entries[i].getDate(), entries[i].getType(), entries[i].getAmount(), currentVal);
		}

		return bookings;
	}

}
