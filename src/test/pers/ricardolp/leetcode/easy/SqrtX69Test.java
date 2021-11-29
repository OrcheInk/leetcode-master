package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_69 : Sqrt(x).
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class SqrtX69Test {
    private SqrtX69 solution;

    private int x = 8;

    private int answer = 2;

    @BeforeEach
    public void setUp() {
        solution = new SqrtX69();
    }

    @Test
    void mySqrt1() {
        int result = solution.mySqrt1(x);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void mySqrt2() {
        int result = solution.mySqrt2(x);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void mySqrt3() {
        int result = solution.mySqrt3(x);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void mySqrt4() {
        int result = solution.mySqrt4(x);
        Assertions.assertEquals(answer, result);
    }

}