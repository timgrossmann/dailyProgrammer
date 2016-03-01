package highestProdOfThreeInts;

import java.util.List;

public class Prodder {

	public static int get(List<Integer> listOfInts) {

		if (listOfInts.size() < 3) {
			return 0;
		}

		int longestProd = listOfInts.get(0) * listOfInts.get(1) * listOfInts.get(2);
		int output = 0;
		int length = listOfInts.size();

		for (int i = 3; i < length; i++) {

			if (listOfInts.get(i) == 0 && i + 3 > length) {
				break;
			} else if (listOfInts.get(i) == 0) {
				i += 3;
				longestProd = listOfInts.get(i - 2) * listOfInts.get(i - 1) * listOfInts.get(i);
			} else {

				if (listOfInts.get(i - 3) != 0) {
					longestProd /= listOfInts.get(i - 3);
				}
				longestProd *= listOfInts.get(i);

			}

			if (output < longestProd) {
				output = longestProd;
			}

		}

		return output;
	}

}
