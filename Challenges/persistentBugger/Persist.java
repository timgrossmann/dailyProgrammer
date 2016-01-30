package persistentBugger;

class Persist {

	public static int persistence(long n) {

		if (n / 10 == 0) {
			return 0;
		}

		long temp = 1;
		while (n != 0) {
			temp *= n % 10;
			n /= 10;
		}
		return persistence(temp) + 1;
	}

}