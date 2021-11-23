package pers.ricardolp.leetcode.easy;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Summary description.
 * <p>
 * Detail description
 *
 * @author RicardoLP
 * @since 2021/11/23
 */
class MergeSortedArray88Test {

    private MergeSortedArray88 solution;

    @BeforeEach
    public void setUp() {
        solution = new MergeSortedArray88();
    }

    @Test
    void merge1() {}

    @Test
    void merge2() {
        int[] nums1 = {1, 2, 3, 4, 5, 0, 0, 0, 0};
        int m = nums1.length;
        int[] nums2 = {6, 7, 8, 9};
        int n = nums2.length;
        solution.merge2(nums1, m - n, nums2, n);
        System.out.println("nums1 " + Arrays.toString(nums1));
    }

    @Test
    void merge3() {}

    @Test
    void merge4() {}
}