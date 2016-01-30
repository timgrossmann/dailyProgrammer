package rotate1DArray;

public class Tester {

	public static void main(String[] args) {
		
		Rotator rotator = new Rotator();
		
		rotator.rotate(new Object[]{1, 2, 3, 4, 5}, 1);
		
		rotator.rotate(new Object[]{1, 2, 3, 4, 5}, -1);
		
		
	}

}
