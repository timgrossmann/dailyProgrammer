package pyramidSlideDown;

public class PyramidSlideDown {

	public static int longestSlideDown(int[][] pyramid) {

		int[][] copyOfPyramid = new int[pyramid.length][];
		for (int i = 0; i < pyramid.length; i++) {
			copyOfPyramid[i] = pyramid[i].clone();
		}

		for (int i = 0; i < pyramid.length - 1; i++) {
			for (int j = 0; j < pyramid[i].length; j++) {
				if (pyramid[i + 1][j] < (pyramid[i][j] + copyOfPyramid[i + 1][j])) {
					pyramid[i + 1][j] = pyramid[i][j] + copyOfPyramid[i + 1][j];
				}
				if (pyramid[i + 1][j + 1] < (pyramid[i][j] + copyOfPyramid[i + 1][j + 1])) {
					pyramid[i + 1][j + 1] = pyramid[i][j] + copyOfPyramid[i + 1][j + 1];
				}
			}
		}

		int longestWay = 0;
		for (int i = 0; i < pyramid[pyramid.length - 1].length; i++) {
			if (pyramid[pyramid.length - 1][i] > longestWay) {
				longestWay = pyramid[pyramid.length - 1][i];
			}
		}

		return longestWay;
	}

	@SuppressWarnings("unused")
	private static void printAr(int[][] array) {
		for (int[] i : array) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}
