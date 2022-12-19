package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_121 : Best Time to Buy and Sell Stock.
 *
 * @author RicardoLP
 * @since 2021/12/29
 */
class BestTimeToBuyAndSellStock121Test {

    private BestTimeToBuyAndSellStock121 solution;

    private int[] prices = {6, 5, 4, 2, 5, 7, 3, 4, 9, 3, 9};

    private int answer = 7;

    @BeforeEach
    public void setUp() {
        solution = new BestTimeToBuyAndSellStock121();
    }

    @Test
    void maxProfit1() {
        int result = solution.maxProfit1(prices);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void maxProfit2() {
        int result = solution.maxProfit2(prices);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void maxProfit3() {
        int result = solution.maxProfit3(prices);
        Assertions.assertEquals(answer, result);
    }

}