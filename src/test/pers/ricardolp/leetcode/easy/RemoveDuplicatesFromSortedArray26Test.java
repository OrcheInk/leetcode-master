package pers.ricardolp.leetcode.easy;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_26 : Remove Duplicates from Sorted Array.
 *
 * @author RicardoLP
 * @since 2021/11/28
 */
class RemoveDuplicatesFromSortedArray26Test {

    private RemoveDuplicatesFromSortedArray26 solution;

    private int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    private int answer1 = 5;
    private String answer2 = "[0, 1, 2, 3, 4";

    @BeforeEach
    public void setUp() {
        solution = new RemoveDuplicatesFromSortedArray26();
    }

    @Test
    void removeDuplicates1() {
        int result = solution.removeDuplicates1(nums);
        Assertions.assertEquals(answer1, result);
        String s = Arrays.toString(nums);
        Assertions.assertTrue(s.startsWith(answer2));
    }

    @Test
    void removeDuplicates2() {
        int result = solution.removeDuplicates2(nums);
        Assertions.assertEquals(answer1, result);
        String s = Arrays.toString(nums);
        Assertions.assertTrue(s.startsWith(answer2));
    }

    @Test
    void removeDuplicates3() {
        int result = solution.removeDuplicates3(nums);
        Assertions.assertEquals(answer1, result);
        String s = Arrays.toString(nums);
        Assertions.assertTrue(s.startsWith(answer2));
    }

}