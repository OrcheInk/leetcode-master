package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_14 : Longest Common Prefix.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class LongestCommonPrefix14Test {

    private LongestCommonPrefix14 solution;

    private String[] strs = {"flower", "flow", "flight"};

    private String answer = "fl";

    @BeforeEach
    public void setUp() {
        solution = new LongestCommonPrefix14();
    }

    @Test
    void longestCommonPrefix1() {
        String result = solution.longestCommonPrefix1(strs);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void longestCommonPrefix2() {
        String result = solution.longestCommonPrefix2(strs);
        Assertions.assertEquals(answer, result);
    }

}