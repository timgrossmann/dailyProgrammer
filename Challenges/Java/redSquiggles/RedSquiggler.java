package redSquiggles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RedSquiggler {

	private HashSet<String> wordList = new HashSet<String>();

	public RedSquiggler() {
		try {
			ArrayList<String> words = (ArrayList<String>) Files.readAllLines(Paths.get("enable1.txt"));

			for (String s : words) {
				for (int i = 1; i <= s.length(); i++) {
					wordList.add(s.substring(0, i));
				}
			}

		} catch (IOException e) {
			System.out.println("Error");
		}

	}

	public void checkWords(List<String> testStrings) {

		
		for(String s : testStrings) {
			StringBuilder temp = new StringBuilder(s);
			for(int i = 1; i <= s.length(); i++) {
				if(!wordList.contains(s.substring(0, i))) {
					temp.insert(i, "<");
					break;
				}
			}
			System.out.println(temp);
		}
		
		
	}

}
