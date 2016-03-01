package brokenKeyboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BrokenKeyboardSearchUpdated {

	private static List<String> enable1 = new ArrayList<String>();

	public static void getWords(String[] inputLines) {

		String[] outputWords = new String[inputLines.length];

		readEnable1();

		for (int i = 0; i < inputLines.length; i++) {
			outputWords[i] = getLongestWord(inputLines[i]);
		}

		printWords(inputLines, outputWords);

	}

	private static String getLongestWord(String letters) {

		int longestCount = 0;
		String longestWord = "";

		for (int j = 0; j < enable1.size(); j++) {

			if (enable1.get(j).matches("[" + letters + "]+") && longestCount < enable1.get(j).length()) {
				longestCount = enable1.get(j).length();
				longestWord = enable1.get(j);
			}

		}

		return longestWord;
	}

	private static void printWords(String[] inputLines, String[] outputWords) {
		for (int i = 0; i < outputWords.length; i++) {
			System.out.println(inputLines[i] + " = " + outputWords[i]);
		}
	}

	private static void readEnable1() {
		try {
			enable1 = Files.readAllLines(Paths.get("enable1.txt"));
		} catch (IOException e) {
		}
	}

}
