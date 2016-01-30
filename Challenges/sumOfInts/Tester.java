package sumOfInts;

import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> ints = new ArrayList<Integer>();
		
		ints.add(1);
		ints.add(7);
		ints.add(3);
		ints.add(4);		

		
		SummerOfInts.get_products_of_all_ints_except_at_index(ints);
		
		
	}

}
