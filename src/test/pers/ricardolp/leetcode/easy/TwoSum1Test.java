package pers.ricardolp.leetcode.easy;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_1 : Two Sum.
 *
 * @author RicardoLP
 * @since 2021/11/17
 */
class TwoSum1Test {

    private int[] nums = {2, 6, 15, 4, 11, 7, 12};
    private int target = 10;
    private TwoSum1 solution;

    @BeforeEach
    public void initialize() {
        solution = new TwoSum1();
    }

    @Test
    void twoSum1() {
        int[] result = solution.twoSum1(nums, target);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void twoSum2() {
        int[] result = solution.twoSum2(nums, target);
        System.out.println(Arrays.toString(result));
    }

}