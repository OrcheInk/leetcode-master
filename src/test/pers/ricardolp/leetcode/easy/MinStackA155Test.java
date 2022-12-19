package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_155 : Min Stack.
 *
 * @author RicardoLP
 * @since 2022/1/3
 */
class MinStackC155ATest {

    private MinStackA155 solution;

    @BeforeEach
    public void setUp() {
        solution = new MinStackA155();
    }

    @Test
    void MinStackA155() {

        solution.push(5);
        solution.push(-3);
        solution.push(2);
        solution.push(-4);

        solution.pop();

        int top = solution.top();
        Assertions.assertEquals(2, top);

        int min = solution.getMin();
        Assertions.assertEquals(-3, min);
    }

}