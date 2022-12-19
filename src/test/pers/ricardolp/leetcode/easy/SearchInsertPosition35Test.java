package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * leetcode_35 : Search Insert Position.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class SearchInsertPosition35Test {

    private SearchInsertPosition35 solution;

    @BeforeEach
    public void setUp() {
        solution = new SearchInsertPosition35();
    }

    @Test
    void searchInsert1() {

        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int answer = 2;

        int result = solution.searchInsert1(nums, target);
        Assertions.assertEquals(answer, result);
    }

}