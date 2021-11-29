package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_53 : Maximum Subarray.
 *
 * @author RicardoLP
 * @since 2021/11/28
 */
class MaximumSubarray53Test {

    private MaximumSubarray53 solution;

    private int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    private int answer = 6;

    @BeforeEach
    public void setUp() {
        solution = new MaximumSubarray53();
    }

    @Test
    void maxSubArray1() {
        int result = solution.maxSubArray1(nums);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void maxSubArray2() {
        int result = solution.maxSubArray2(nums);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void maxSubArray3() {
        int result = solution.maxSubArray3(nums);
        Assertions.assertEquals(answer, result);
    }

}