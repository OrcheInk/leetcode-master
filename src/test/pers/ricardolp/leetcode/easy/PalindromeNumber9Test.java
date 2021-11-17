package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Summary description
 * <p>
 * Detail description
 *
 * @author RicardoLP
 * @since 2021/11/17
 */
class PalindromeNumber9Test {

    private int x = 1435341;
    private PalindromeNumber9 solution;

    @BeforeEach
    public void initialize() {
        solution = new PalindromeNumber9();
    }

    @Test
    void isPalindrome1() {
        boolean result = solution.isPalindrome1(x);
        System.out.println(result);
    }

    @Test
    void isPalindrome2() {
        boolean result = solution.isPalindrome2(x);
        System.out.println(result);
    }

    @Test
    void isPalindrome3() {
        boolean result = solution.isPalindrome3(x);
        System.out.println(result);
    }
}