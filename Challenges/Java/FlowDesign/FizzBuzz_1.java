package grossmann.tim.FlowDesign;

public class FizzBuzz_1 {
	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {

			boolean contains5 = String.valueOf(i).contains("5");
			boolean contains3 = String.valueOf(i).contains("3");

			if (i % 15 == 0 || (contains3 && contains5)) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0 || contains3) {
				System.out.println("Fizz");
			} else if (i % 5 == 0 || contains5) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}

		}

	}
}
