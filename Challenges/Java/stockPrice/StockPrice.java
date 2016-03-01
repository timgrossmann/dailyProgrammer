package stockPrice;

import java.util.List;

public class StockPrice {

	public static int get_max_profit(List<Integer> stockPrices) {

		//not possible, since you need to buy before you sell and at least 1 minute must pass (1 index per definition)
		if (stockPrices.size() < 2) {
			return 0;
		}

		//Setting the minPrize as the first item of the list
		int minPrize = stockPrices.get(0);

		//getting the profit of the first 2 numbers in the list
		int maxProfit = stockPrices.get(1) - stockPrices.get(0);

		//iterating through the list starting at the second one (because the first one was calculated ontop)
		for (int i = 1; i < stockPrices.size(); i++) {

			//looking at the profit of the prize at the currentPosition and the minPrize of the list
			int profit = stockPrices.get(i) - minPrize;

			//checking if the profit is higher than the current maximum
			if (profit > maxProfit) {
				maxProfit = profit;
			}

			//looking if the current Price is the new minPrize
			if (stockPrices.get(i) < minPrize) {
				minPrize = stockPrices.get(i);
			}

		}

		return maxProfit;
	}

}
