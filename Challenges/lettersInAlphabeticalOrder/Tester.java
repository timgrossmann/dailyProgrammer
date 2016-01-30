package lettersInAlphabeticalOrder;

public class Tester {

	public static void main(String[] args) {

		String[] test = { "billowy", "biopsy", "chinos", "defaced", "chintz", "sponged", "bijoux", "abhors", "fiddle",
				"begins", "chimps", "wronged", };

		for (String s : test) {
			AlphabeticalOrder.testForOrder(s);
		}
	}

}
