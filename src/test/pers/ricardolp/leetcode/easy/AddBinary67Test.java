package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_67 : Add Binary.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
class AddBinary67Test {

    private AddBinary67 solution;

    @BeforeEach
    public void setUp() {
        solution = new AddBinary67();
    }

    @Test
    void addBinary1() {

        String a = "1001";
        String b = "110101";

        String result = solution.addBinary1(a, b);
        String answer = "111110";

        Assertions.assertEquals(answer, result);
    }

}