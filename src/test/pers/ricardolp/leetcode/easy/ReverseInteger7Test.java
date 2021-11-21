package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_7 : Reverse Integer.
 *
 * @author RicardoLP
 * @since 2021/11/17
 */
class ReverseInteger7Test {

    private ReverseInteger7 solution;

    private int x = 1941;

    private int answer = 1491;

    @BeforeEach
    public void setUp() {
        solution = new ReverseInteger7();
    }

    @Test
    void reverse1() {
        int result = solution.reverse1(x);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void reverse2() {
        int result = solution.reverse2(x);
        Assertions.assertEquals(answer, result);
    }

}