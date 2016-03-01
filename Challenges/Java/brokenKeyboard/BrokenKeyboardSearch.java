package brokenKeyboard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BrokenKeyboardSearch {

	private static List<String> enable1 = new ArrayList<String>();

	public static void getWords(String[] inputLines) {

		String[] outputWords = new String[inputLines.length];

		readEnable1();

		for (int i = 0; i < outputWords.length; i++) {
			outputWords[i] = getLongestWord(inputLines[i]);
		}

		printWords(inputLines, outputWords);

	}

	private static String getLongestWord(String letters) {

		char[] letterSequence = letters.toCharArray();

		int longestCount = 0;
		String longestWord = "";

		for (int i = 0; i < letterSequence.length; i++) {

			for (int j = 0; j < enable1.size(); j++) {

				if (enable1.get(j).startsWith(String.valueOf(letterSequence[i]))) {
					if (longestCount < enable1.get(j).length()) {
						boolean isOnlyLetters = checkWord(letterSequence, enable1.get(j));
						if (isOnlyLetters) {
							longestCount = enable1.get(j).length();
							longestWord = enable1.get(j);
//							System.out.println(longestCount);
//							System.out.println(longestWord);
						}
					}
				}

			}
		}

		return longestWord;
	}

	private static boolean checkWord(char[] letterSequence, String word) {
		
		char[] lettersInWord = word.toCharArray();
		int wordChecks = 0;
		
		for(int i = 0; i < lettersInWord.length; i++) {
			for(int j = 0; j < letterSequence.length; j++) {
				if(lettersInWord[i] == letterSequence[j]) {
					wordChecks++;
					break;
				}
			}
			
		}
		

		if(lettersInWord.length == wordChecks) {
			return true;
		} else {
			return false;
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
