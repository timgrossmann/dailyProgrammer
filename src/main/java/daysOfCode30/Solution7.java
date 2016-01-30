package daysOfCode30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution7 {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		final Scanner scanner = new Scanner(System.in);

		int listLength = scanner.nextInt();
		scanner.nextLine();

		List<Integer> numbers = new ArrayList<>(listLength);

		for (int i = 0; i < listLength; i++) {
			numbers.add(scanner.nextInt());
		}

		scanner.close();

		Collections.sort(numbers);

		int smallestDist = Integer.MAX_VALUE;

		for(int i = 0; i < numbers.size() - 1; i++) {
			int dist = Math.abs(numbers.get(i) - numbers.get(i + 1));
			
			if(dist < smallestDist) {
				smallestDist = dist;
			}
		}
		
		List<String> output = new ArrayList<>();
		
		for(int i = 0; i < numbers.size() - 1; i++) {
			int dist = Math.abs(numbers.get(i) - numbers.get(i + 1));
			
			if(dist == smallestDist) {
				int[] out = new int[]{numbers.get(i), numbers.get(i + 1)};
				Arrays.sort(out);
				output.add(out[0] + " " + out[1] + " ");
			}
		}
		
		for(String s : output) {
			System.out.print(s);
		}
		

	}

}