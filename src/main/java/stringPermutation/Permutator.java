package stringPermutation;

import java.util.HashSet;
import java.util.Set;

public class Permutator {

	private static Set<String> outputSet = new HashSet<String>();
	private static Set<String> finalOut = new HashSet<String>();
	private static long numberOfPerms = 0;

	public static void getEveryPosPermut(String input) {

		String startString = input.substring(0, 2);
		int nextMark = 3;
		int startVal = 2;

		System.out.println(startString);
		outputSet.add(startString);
		System.out.println((String.valueOf(startString.charAt(1) + "" + startString.charAt(0))));
		outputSet.add((String.valueOf(startString.charAt(1) + "" + startString.charAt(0))));
		System.out.println(2);
		System.out.println();

		while (nextMark <= input.length()) {

			for (int i = startVal; i < nextMark; i++) {
				for (String s : outputSet) {
					addAllPermuts(s, input.charAt(i));
				}
			}

			startVal++;
			nextMark++;

			outputSet = finalOut;
			finalOut = new HashSet<String>();

			System.out.println(numberOfPerms);
			numberOfPerms = 0;
			System.out.println();

		}

	}

	private static void addAllPermuts(String input, char currentChar) {

		StringBuilder temp = new StringBuilder(input);

		for (int i = 0; i <= input.length(); i++) {
			numberOfPerms++;
			temp.insert(i, String.valueOf(currentChar));
			System.out.println(temp);
			finalOut.add(temp.toString());
			temp = new StringBuilder(input);
		}

	}

}
