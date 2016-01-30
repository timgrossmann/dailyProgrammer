package garlandWords;

public class Garland {

	public static void garlande(String s) {

		int maxGarl = 0;

		// looking for the highest match
		for (int i = 1; i <= s.length() - 1; i++) {

			if (s.substring(0, i).equals(
					s.substring(s.length() - i, s.length()))) {
				maxGarl = i + 1;
			}

		}

		System.out.print(s + ": ");

		if (maxGarl == 0) {
			System.out.println("No Garland found");
		} else if (maxGarl < 4) {

			// printing out the text
			for (int i = 0; i <= 5; i++) {
				System.out.print(s.substring(0, maxGarl));
			}
			System.out.print("... with Size " + (maxGarl - 1) + "\n");

		} else {

			// printing out the text
			for (int i = 0; i <= 5; i++) {
				System.out.print(s.substring(0, maxGarl - 2));
			}
			System.out.print("... with Size " + (maxGarl - 1) + "\n");
		}
	}

}
