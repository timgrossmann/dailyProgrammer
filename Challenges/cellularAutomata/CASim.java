package cellularAutomata;

public class CASim {

	private static String[] states;
	private static String[] cases = { "XXX", "X X", " X ", "   ", "XX ", "X  ", " XX", "  X" };

	public static void simulate(String input) {

		char[] startVals = input.toCharArray();

		states = new String[startVals.length];

		for (int i = 0; i < states.length; i++) {
			if (startVals[i] == '1') {
				states[i] = "X";
			} else {
				states[i] = " ";
			}
		}

		print();

		for (int i = 0; i < 45; i++) {
			calcNext();
			print();
		}

	}

	private static void calcNext() {
		
		String[] temp = new String[states.length];

		for (int i = 0; i < states.length; i++) {
			if (i == 0) {
				temp[i] = checkCases(" " + states[i] + states[i + 1], i);
			} else if (i == states.length - 1) {
				temp[i] = checkCases(states[i - 1] + states[i] + " ", i);
			} else {
				temp[i] = checkCases(states[i - 1] + states[i] + states[i + 1], i);
			}
		}
		states = temp;
	}

	private static String checkCases(String toTest, int pos) {

		for (int i = 0; i < cases.length; i++) {
			if (toTest.equals(cases[i])) {
				if (i < 4) {
					return " ";
				} else {
					return "X";
				}
			}
		}
		
		return " ";

	}

	private static void print() {
		for (String s : states) {
			System.out.print(s);
		}
		System.out.println();
	}

}
