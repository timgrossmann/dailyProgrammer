package needleInHaystack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchEngine {
	static int find(String needle, String haystack) {
		
		if(needle.equals(haystack)) {
			return 0;
		}
		
		Pattern regEx = Pattern.compile(needle.replaceAll("_", "[A-Za-z0-9-.,&%\\$]"));
		Matcher matcher = regEx.matcher(haystack);

		return (matcher.find() ? matcher.start() : -1);
	}
}


