package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_58 : Length of Last Word.
 *
 * @author RicardoLP
 * @since 2021/11/19
 */
class LengthOfLastWord58Test {

    private LengthOfLastWord58 solution;

    @BeforeEach
    public void setUp() {
        solution = new LengthOfLastWord58();
    }

    @Test
    void lengthOfLastWord1() {

        String s = "   fly me   to   the moon  ";
        int answer = 4;

        int result = solution.lengthOfLastWord1(s);
        Assertions.assertEquals(answer, result);
    }

}