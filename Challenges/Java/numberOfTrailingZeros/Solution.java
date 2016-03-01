package numberOfTrailingZeros;

import java.math.BigInteger;

public class Solution {
	public static int zeros(int n) {

		int numOfZeros = 0;

		if (n == 0) {
			return numOfZeros;
		}

		BigInteger factorial = new BigInteger(String.valueOf(n));
		for (int i = n - 1; i >= 1; i--) {
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		}

		String temp = factorial.toString();
		
		String numString = factorial.toString().substring(temp.length() / 2, temp.length());
		int stringLength = numString.length();

		while (numString.substring(stringLength - 1, stringLength).equals("0")) {
			numOfZeros++;
			stringLength--;
		}
		
		System.out.println(temp);

		return numOfZeros;
	}
}