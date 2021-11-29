package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_66 : Plus One.
 *
 * @author RicardoLP
 * @since 2021/11/28
 */
class PlusOne66Test {

    private PlusOne66 solution;

    private int[] digits = {4, 3, 2, 1};

    private int[] answer = {4, 3, 2, 2};

    @BeforeEach
    public void setUp() {
        solution = new PlusOne66();
    }

    @Test
    void plusOne1() {
        int[] result = solution.plusOne1(digits);
        Assertions.assertArrayEquals(answer, result);
    }

}