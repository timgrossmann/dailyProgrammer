package weightForWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WeightSort {

	public static String orderWeight(String string) {

		if (string.split(" ").length == 1) {
			return string;
		}

		Comparator<String> weightedString = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (getSumOfDigits(o1) == getSumOfDigits(o2)) {

					int length = o1.length() < o2.length() ? o1.length() : o2.length();

					if (o1.substring(0, length).equals(o2.substring(0, length)) && o1.length() != o2.length()) {
						return o1.length() < o2.length()
								? Integer.compare(Integer.parseInt(o1.substring(0, length)),
										Integer.parseInt(o2.substring(0, length + 1)))
								: Integer.compare(Integer.parseInt(o1.substring(0, length + 1)),
										Integer.parseInt(o2.substring(0, length)));
					} else {

						return Integer.compare(Integer.parseInt(o1.substring(0, length)),
								Integer.parseInt(o2.substring(0, length)));
					}

				} else {
					return Long.compare(getSumOfDigits(o1), getSumOfDigits(o2));
				}
			}
		};

		List<String> splitList = new ArrayList<String>(Arrays.asList(string.split(" ")));
		splitList.sort(weightedString);

		String outputString = "";

		for (String s : splitList) {
			outputString += s + " ";
		}

		return outputString.trim();
	}

	private static long getSumOfDigits(String s) {

		long n = Long.parseLong(s);
		long returnLong = 0;

		while (n != 0) {
			returnLong += n % 10;
			n /= 10;
		}

		return returnLong;

	}

}