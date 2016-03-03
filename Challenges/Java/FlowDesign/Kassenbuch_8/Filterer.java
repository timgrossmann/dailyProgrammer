package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Filterer {

	public static Entry[] getAllTransactionsBefore(Entry[] entries, LocalDate month) {

		List<Entry> entriesBeforeMonth = new ArrayList<Entry>();

		for (Entry entry : entries) {
			if (entry.getDate().getMonthValue() < month.getMonthValue()) {
				entriesBeforeMonth.add(entry);
			}
		}

		return entriesBeforeMonth.toArray(new Entry[entriesBeforeMonth.size()]);
	}

	public static Booking[] filterByDate(Booking[] bookings, LocalDate localDate) {

		List<Booking> booking = new ArrayList<>();

		for (Booking book : bookings) {
			if (book.getDate().getMonthValue() == localDate.getMonthValue()) {
				booking.add(book);
			}
		}

		return booking.toArray(new Booking[booking.size()]);
	}

}
