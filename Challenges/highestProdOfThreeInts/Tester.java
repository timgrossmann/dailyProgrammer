package highestProdOfThreeInts;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {

		List<Integer> temp = new ArrayList<Integer>();
		temp.add(3);
		temp.add(11);
		temp.add(5);
		temp.add(8);
		temp.add(4);
		temp.add(0);
		temp.add(0);
		temp.add(0);
		temp.add(0);
		temp.add(9);
		temp.add(2);
		temp.add(7);
		temp.add(12);
		temp.add(0);
		temp.add(1);
		temp.add(11);
		temp.add(8);
		temp.add(9);

		System.out.println(Prodder.get(temp));

	}

}
