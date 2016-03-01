package sumOfInts;

import java.util.ArrayList;
import java.util.List;

public class SummerOfInts {

	public static void get_products_of_all_ints_except_at_index(List<Integer> listOfInts) {

		List<Integer> listOfIntsCounts = new ArrayList<Integer>();

		int bfIDX = 1;

		for (int i = 0; i < listOfInts.size(); i++) {
			listOfIntsCounts.add(bfIDX);
			bfIDX *= listOfInts.get(i);
		}

		for (int i : listOfInts) {
			System.out.print(i + " ");
		}

		System.out.println();

		int afIDX = 1;

		for (int i = listOfIntsCounts.size() - 1; i >= 0; i--) {
			listOfIntsCounts.set(i, listOfIntsCounts.get(i) * afIDX);
			afIDX *= listOfInts.get(i);
		}

		for (int i : listOfIntsCounts) {
			System.out.print(i + " ");
		}

	}

}
