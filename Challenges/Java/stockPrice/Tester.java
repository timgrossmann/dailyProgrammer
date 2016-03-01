package stockPrice;

import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {

		List<Integer> stockPrices = new ArrayList<Integer>();
		stockPrices.add(10);
		stockPrices.add(7);
		stockPrices.add(5);
		stockPrices.add(8);
		stockPrices.add(11);
		stockPrices.add(9);
		
//		stockPrices.add(0);
//		stockPrices.add(-1);
//		stockPrices.add(-5);
//		stockPrices.add(-2);
//		stockPrices.add(-9);
//		stockPrices.add(-7);
//		stockPrices.add(-2);
		
//		stockPrices.add(0);
//		stockPrices.add(-1);
//		stockPrices.add(-2);
//		stockPrices.add(-4);
//		stockPrices.add(-7);
//		stockPrices.add(-9);
//		stockPrices.add(-11);
		
		

		int output = StockPrice.get_max_profit(stockPrices);

		System.out.println(output);

	}

}
