package ackermannFunction;

public class Solution {

	public int Ackermann(int m, int n) {

		int returnNumber = 0;

		if (m < 0 || n < 0) {
			return returnNumber;
		}

		if (m == 0) {
			return n + 1;
		} else if (m > 0 && n == 0) {
			return Ackermann(m - 1, 1);
		} else if (m > 0 && n > 0) {
			return Ackermann(m - 1, Ackermann(m, n - 1));
		}

		return returnNumber;
	}
}