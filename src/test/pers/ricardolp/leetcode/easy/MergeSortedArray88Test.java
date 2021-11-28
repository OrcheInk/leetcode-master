package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
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

    private int[] nums1 = {1, 2, 3, 4, 5, 0, 0, 0, 0};
    private int m = nums1.length;
    private int[] nums2 = {6, 7, 8, 9};
    private int n = nums2.length;

    private int[] answer = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    @BeforeEach
    public void setUp() {
        solution = new MergeSortedArray88();
    }

    @Test
    void merge1() {
        solution.merge1(nums1, m - n, nums2, n);
        Assertions.assertArrayEquals(answer, nums1);
    }

    @Test
    void merge2() {
        solution.merge2(nums1, m - n, nums2, n);
        Assertions.assertArrayEquals(answer, nums1);
    }

    @Test
    void merge3() {
        solution.merge3(nums1, m - n, nums2, n);
        Assertions.assertArrayEquals(answer, nums1);
    }

    @Test
    void merge4() {
        solution.merge4(nums1, m - n, nums2, n);
        Assertions.assertArrayEquals(answer, nums1);
    }

}