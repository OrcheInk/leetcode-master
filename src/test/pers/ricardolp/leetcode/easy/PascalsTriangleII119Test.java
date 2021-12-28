package pers.ricardolp.leetcode.easy;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_119 : Pascal's Triangle II.
 *
 * @author RicardoLP
 * @since 2021/12/28
 */
class PascalsTriangleII119Test {

    private PascalsTriangleII119 solution;

    @BeforeEach
    public void setUp() {
        solution = new PascalsTriangleII119();
    }

    @Test
    void getRow() {

        int rowIndex = 4;
        String answer = "[1, 4, 6, 4, 1]";

        List<Integer> result = solution.getRow(rowIndex);
        Assertions.assertEquals(answer, result.toString());
    }

}