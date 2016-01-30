package rotate1DArray;

public class Rotator {

	public Object[] rotate(Object[] data, int n) {

		Object[] rotated = new Object[data.length];

		for (int i = 0; i < data.length; i++) {
			rotated[i] = data[Math.floorMod((i - n), data.length)];
		}

		printAr(data);
		printAr(rotated);
		System.out.println();
		return rotated;
	}

	private void printAr(Object[] arr) {
		for (Object o : arr) {
			System.out.print(o + ", ");
		}
		System.out.println();
	}

}