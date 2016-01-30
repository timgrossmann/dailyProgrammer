package compoundArray;

public class CompoundArray {

	public static int[] compoundArray(int[] a, int[] b) {

		int[] finalArray = new int[a.length + b.length];
		int index = 0;
		int smallestSize = 0;

		if (a.length > b.length) {
			smallestSize = a.length;
		} else {
			smallestSize = b.length;
		}

		for (int i = 0; i < smallestSize; i++) {
			if (i < a.length) {
				finalArray[index++] = a[i];
			}
			if (i < b.length) {
				finalArray[index++] = b[i];
			}
		}

		printAr(finalArray);
		System.out.println();
		return finalArray;
	}

	private static void printAr(int[] array) {
		for (int i : array) {
			System.out.print(i + ", ");
		}
	}
}