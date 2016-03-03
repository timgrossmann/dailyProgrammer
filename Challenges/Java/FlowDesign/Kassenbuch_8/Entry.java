package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.time.LocalDate;

public class Entry {

	private LocalDate date;
	private String type;
	private double amount;

	public Entry(LocalDate localDate, String type, double amount) {
		super();
		this.date = localDate;
		this.type = type;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

}
