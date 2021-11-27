package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_1 : Two Sum.
 *
 * @author RicardoLP
 * @since 2021/11/17
 */
class TwoSum1Test {

    private TwoSum1 solution;

    private int[] nums = {2, 6, 15, 4, 11, 7, 12};
    private int target = 10;

    private int[] answer = {1, 3};

    @BeforeEach
    public void setUp() {
        solution = new TwoSum1();
    }

    @Test
    void twoSum1() {
        int[] result = solution.twoSum1(nums, target);
        Assertions.assertArrayEquals(answer, result);
    }

    @Test
    void twoSum2() {
        int[] result = solution.twoSum2(nums, target);
        Assertions.assertArrayEquals(answer, result);
    }

}