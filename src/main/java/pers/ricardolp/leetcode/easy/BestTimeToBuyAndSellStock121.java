package pers.ricardolp.leetcode.easy;

/**
 * leetcode_121 : Best Time to Buy and Sell Stock.
 * <p>
 * You are given an array {@code prices} where {@code prices[i]} is the price of
 * a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return {@code 0}.
 *
 * <pre>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done, and the max profit = 0.
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} prices.length {@code <=} 10<sup>5</sup> <br>
 * 0 {@code <=} prices[i] {@code <=} 10<sup>4</sup>
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class BestTimeToBuyAndSellStock121 {

    /**
     * Solution1.
     * <p>
     * Traverse once.
     *
     * @param prices the price of the stock per day.
     * @return the profit this week.
     */
    public int maxProfit1(int[] prices) {

        int buy = 0;
        int sell = 1;
        int profit = 0;

        // Iterate over the price of each day.
        while (sell < prices.length) {

            // Select the lowest price before selling.
            if (prices[buy] < prices[sell]) {

                // Calculate maximum profit.
                profit = Math.max(prices[sell] - prices[buy], profit);
            } else {
                buy = sell;
            }
            sell++;
        }
        return profit;
    }

    /**
     * Solution2.
     * <p>
     * Traverse once.
     *
     * @param prices the price of the stock per day.
     * @return the profit this week.
     */
    public int maxProfit2(int[] prices) {

        int buy = Integer.MAX_VALUE;
        int profit = 0;

        // Iterate over the price of each day.
        for (int sell : prices) {

            // Select the lowest price before selling.
            if (sell < buy) {
                buy = sell;

            } else if (sell - buy > profit) {

                // Calculate maximum profit.
                profit = sell - buy;
            }
        }

        return profit;
    }

    /**
     * Solution3.
     * <p>
     * Brute force.
     *
     * @param prices the price of the stock per day.
     * @return the profit this week.
     */
    public int maxProfit3(int[] prices) {

        int maxprofit = 0;

        // Iterate over the price of each day.
        for (int i = 0; i < prices.length - 1; i++) {

            // Traverse price per day after this day.
            for (int j = i + 1; j < prices.length; j++) {

                // Calculate profit.
                int profit = prices[j] - prices[i];

                // Calculate maximum profit.
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

}
