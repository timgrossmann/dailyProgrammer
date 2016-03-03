package grossmann.tim.FlowDesign;

public class CSVTabellier_5 {

	public static void main(String[] args) {

		String[] tabluatedInput = tabulateCSV(args);
		printTable(tabluatedInput);

	}

	private static String[] tabulateCSV(String[] args) {

		String[][] splittedLines = splitIntoColumns(args);
		String[] formattedTable = formatTable(splittedLines);

		return formattedTable;
	}

	private static String[][] splitIntoColumns(String[] args) {

		String[][] splittedLines = new String[args.length][args[0].split(";").length];

		for (int i = 0; i < splittedLines.length; i++) {
			splittedLines[i] = args[i].split(";");
		}

		return splittedLines;
	}

	private static String[] formatTable(String[][] splittedLines) {

		int[] longestWords = findWidestWordPerCol(splittedLines);
		String[] formattedLines = fillColumns(longestWords, splittedLines);

		return formattedLines;
	}

	private static String[] fillColumns(int[] longestWords, String[][] splittedLines) {

		String[] formattedLines = new String[splittedLines.length + 1];

		String header = formatHeader(longestWords, splittedLines);
		String separatingLine = formatSeparatingline(longestWords, splittedLines);
		String[] body = formatBody(longestWords, splittedLines);

		formattedLines[0] = header;
		formattedLines[1] = separatingLine;
		for (int i = 0; i < body.length; i++) {
			formattedLines[i + 2] = body[i];
		}

		return formattedLines;
	}

	private static String[] formatBody(int[] longestWords, String[][] splittedLines) {

		String[] body = new String[splittedLines.length - 1];

		for (int k = 1; k < splittedLines.length; k++) {
			String line = "";
			for (int i = 0; i < splittedLines[0].length; i++) {

				String spaces = "";
				for (int j = 0; j < longestWords[i]; j++) {
					spaces += " ";
				}

				line += (splittedLines[k][i] + spaces).substring(0, longestWords[i]) + "|";
			}
			body[k - 1] = line;
		}

		return body;
	}

	private static String formatSeparatingline(int[] longestWords, String[][] splittedLines) {

		String separatingLine = "";

		for (int i = 0; i < splittedLines[0].length; i++) {

			String dashes = "";
			for (int j = 0; j < longestWords[i]; j++) {
				dashes += "-";
			}

			separatingLine += dashes + "+";
		}

		return separatingLine;
	}

	private static String formatHeader(int[] longestWords, String[][] splittedLines) {

		String header = "";

		for (int i = 0; i < splittedLines[0].length; i++) {

			String spaces = "";
			for (int j = 0; j < longestWords[i]; j++) {
				spaces += " ";
			}

			header += (splittedLines[0][i] + spaces).substring(0, longestWords[i]) + "|";
		}

		return header;
	}

	private static int[] findWidestWordPerCol(String[][] splittedLines) {

		int[] longestWords = new int[splittedLines.length];

		for (int i = 0; i < splittedLines[0].length; i++) {
			int longestWord = splittedLines[0][i].length();
			for (int j = 1; j < splittedLines.length; j++) {
				if (splittedLines[j][i].length() > longestWord) {
					longestWord = splittedLines[j][i].length();
				}
			}
			longestWords[i] = longestWord;
		}

		return longestWords;
	}

	private static void printTable(String[] tabluatedInput) {
		for (String line : tabluatedInput) {
			System.out.println(line);
		}
	}

}
