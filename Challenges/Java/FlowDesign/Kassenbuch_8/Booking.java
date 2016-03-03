package grossmann.tim.FlowDesign.Kassenbuch_8;

import java.time.LocalDate;

public class Booking {

	private LocalDate date;
	private String type;
	private double amount;
	private double cashBalance;

	public Booking(LocalDate date, String type, double amount, double cashBalance) {
		super();
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.cashBalance = cashBalance;
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

	public double getCashBalance() {
		return cashBalance;
	}

}
