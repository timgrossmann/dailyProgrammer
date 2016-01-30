package ruthAronPairs;

import java.util.HashSet;

public class RuthAronPair {

	private static HashSet<Integer> numPrimes = new HashSet<Integer>();
	private static int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79,
			83, 89, 97 };

	public static void testPair(String pair) {

		String[] numbers = pair.split("\\D");

		int firstNum = Integer.parseInt(numbers[1]);
		int secNum = Integer.parseInt(numbers[2]);

		getPrimeFactors(firstNum);

		long sumOfFirstFactors = 0;

		for (int i : numPrimes) {
			sumOfFirstFactors += i;
		}

		numPrimes.clear();
		
		getPrimeFactors(secNum);

		long sumOfSecFactors = 0;

		for (int i : numPrimes) {
			sumOfSecFactors += i;
		}

		if (sumOfFirstFactors == sumOfSecFactors) {
			System.out.println("Valid");
		} else {
			System.out.println("Not Valid");
		}

		numPrimes.clear();
	}

	private static void getPrimeFactors(int number) {

		long num = number;

		while (num != 1) {
			for (int i : primes) {
				if (num % i == 0) {
					numPrimes.add(Integer.valueOf(i));
					num = num / i;
					break;
				}
			}
		}

	}

}
