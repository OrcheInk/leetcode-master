package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_70 : Climbing Stairs.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
class ClimbingStairs70Test {

    private ClimbingStairs70 solution;

    private int n = 30;

    private int answer = 1346269;

    @BeforeEach
    public void setUp() {
        solution = new ClimbingStairs70();
    }

    @Test
    void climbStairs1() {
        int result = solution.climbStairs1(n);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void climbStairs2() {
        int result = solution.climbStairs2(n);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void climbStairs3() {
        int result = solution.climbStairs3(n);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void climbStairs4() {
        int result = solution.climbStairs4(n);
        Assertions.assertEquals(answer, result);
    }

}
