package pers.ricardolp.leetcode.easy;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_27 : Remove Element.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class RemoveElement27Test {

    private RemoveElement27 solution;

    private int[] nums = {3, 2, 2, 3};
    private int val = 3;

    private int answer1 = 2;
    private String answer2 = "[2, 2";

    @BeforeEach
    public void setUp() {
        solution = new RemoveElement27();
    }

    @Test
    void removeElement1() {
        int result = solution.removeElement1(nums, val);
        Assertions.assertEquals(answer1, result);
        Assertions.assertTrue(Arrays.toString(nums).startsWith(answer2));
    }

    @Test
    void removeElement2() {
        int result = solution.removeElement2(nums, val);
        Assertions.assertEquals(answer1, result);
        Assertions.assertTrue(Arrays.toString(nums).startsWith(answer2));
    }

}