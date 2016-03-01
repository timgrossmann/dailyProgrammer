package miniChallenge;

import java.util.ArrayList;
import java.util.Collections;

public class RampNumbers {

	private static ArrayList<Integer> listOfNums = new ArrayList<Integer>();
	private static int numOfRamps = 0;

	public static void getNumOfRamps(int max) {

		for (int i = 1; i <= max; i++) {

			getSingleNums(i);

			Collections.reverse(listOfNums);

			// print();

			boolean isRamp = isRamp();
			if (isRamp) {
				numOfRamps++;
			}

			listOfNums.clear();
			
//			System.out.println();

		}
		System.out.println(numOfRamps);
		numOfRamps = 0;

	}
	
//	private static void print() {
//		
//		for(int i : listOfNums) {
//			System.out.println(i);
//		}
//		
//	}

	private static boolean isRamp() {

		int biggerOnes = 0;

		for (int i = 0; i < listOfNums.size() - 1; i++) {
			if (listOfNums.get(i) <= listOfNums.get(i + 1)) {
				biggerOnes++;
			}
		}

		if (biggerOnes == listOfNums.size() - 1) {
			return true;
		} else {
			return false;
		}

	}

	private static void getSingleNums(int number) {

		while(number != 0) {
			
			listOfNums.add(number % 10);
			number /= 10;
			
		}
		
	}

}
