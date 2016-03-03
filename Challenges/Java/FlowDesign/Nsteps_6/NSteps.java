package grossmann.tim.FlowDesign.Nsteps_6;

public class NSteps {

	public static void main(String[] args) {

		int[] arguments = parseArgs(args);
		printNumberFromCoords(arguments);

	}

	private static void printNumberFromCoords(int[] arguments) {
		checkForValidCoordinates(arguments[0], arguments[1], (x, y) -> printNumber(calculateNumber(x, y)),
				() -> printNoNumber());
	}

	public static int[] parseArgs(String[] values) {

		int[] numbers = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			numbers[i] = Integer.parseInt(values[i]);
		}
		return numbers;
	}

	public static void checkForValidCoordinates(int x, int y, IValidCoords valid, IInvalidCoords invalid) {
		if (x == y || x == y + 2) {
			valid.call(x, y);
		} else {
			invalid.call();
		}
	}

	public static int calculateNumber(int x, int y) {

		int number;

		if (x % 2 == 0) {
			number = x + y;
		} else {
			number = x + y - 1;
		}
		return number;
	}

	public static void printNumber(int number) {
		System.out.println(number);
	}

	public static void printNoNumber() {
		System.out.println("No Number");
	}

}
