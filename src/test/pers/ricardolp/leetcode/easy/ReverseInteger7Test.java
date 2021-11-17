package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_7 : Reverse Integer.
 *
 * @author RicardoLP
 * @since 2021/11/17
 */
class ReverseInteger7Test {

    private int x = 1941;
    private ReverseInteger7 solution;

    @BeforeEach
    public void initialize() {
        solution = new ReverseInteger7();
    }

    @Test
    void reverse1() {
        int result = solution.reverse1(x);
        System.out.println(result);
    }

    @Test
    void reverse2() {
        int result = solution.reverse2(x);
        System.out.println(result);
    }

}