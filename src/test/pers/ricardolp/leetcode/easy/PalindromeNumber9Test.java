package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_9 : Palindrome Number.
 *
 * @author RicardoLP
 * @since 2021/11/17
 */
class PalindromeNumber9Test {

    private PalindromeNumber9 solution;

    private int x = 1435341;

    private boolean answer = true;

    @BeforeEach
    public void setUp() {
        solution = new PalindromeNumber9();
    }

    @Test
    void isPalindrome1() {
        boolean result = solution.isPalindrome1(x);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void isPalindrome2() {
        boolean result = solution.isPalindrome2(x);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void isPalindrome3() {
        boolean result = solution.isPalindrome3(x);
        Assertions.assertEquals(answer, result);
    }

}