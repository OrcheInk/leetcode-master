package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_13 : Roman to Integer.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class RomanToInteger13Test {

    private RomanToInteger13 solution;

    private String s = "MCMXCIV";

    private int answer = 1994;

    @BeforeEach
    public void setUp() {
        solution = new RomanToInteger13();
    }

    @Test
    void romanToInt1() {
        int result = solution.romanToInt1(s);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void romanToInt2() {
        int result = solution.romanToInt2(s);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void romanToInt3() {
        int result = solution.romanToInt3(s);
        Assertions.assertEquals(answer, result);
    }

}