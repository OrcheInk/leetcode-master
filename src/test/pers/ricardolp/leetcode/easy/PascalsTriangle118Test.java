package pers.ricardolp.leetcode.easy;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_118 : Pascal's Triangle.
 *
 * @author RicardoLP
 * @since 2021/12/17
 */
class PascalsTriangle118Test {

    private PascalsTriangle118 solution;

    private int numRows = 5;

    private String answer = "[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]";

    @BeforeEach
    public void setUp() {
        solution = new PascalsTriangle118();
    }

    @Test
    void generate1() {
        List<List<Integer>> result = solution.generate1(numRows);
        Assertions.assertEquals(answer, result.toString());
    }
}