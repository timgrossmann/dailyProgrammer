package matchingParan;

public class Tester {

	public static void main(String[] args) {

		System.out.println(ParenMatcher.getMatchingParen(
				"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.",
				10));
		
		System.out.println(ParenMatcher.getMatchingParen(
				"Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.",
				79));

	}

}
