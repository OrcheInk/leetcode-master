package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_20 : Valid Parentheses.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class ValidParentheses20Test {

    private ValidParentheses20 solution;

    private String s = "()[]{}";

    @BeforeEach
    public void setUp() {
        solution = new ValidParentheses20();
    }

    @Test
    void isValid1() {
        boolean result = solution.isValid1(s);
        Assertions.assertTrue(result);
    }

    @Test
    void isValid2() {
        boolean result = solution.isValid2(s);
        Assertions.assertTrue(result);
    }

    @Test
    void isValid3() {
        boolean result = solution.isValid3(s);
        Assertions.assertTrue(result);
    }

    @Test
    void isValid4() {
        boolean result = solution.isValid4(s);
        Assertions.assertTrue(result);
    }

}