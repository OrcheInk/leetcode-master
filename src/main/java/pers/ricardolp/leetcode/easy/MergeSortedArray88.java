package pers.ricardolp.leetcode.easy;

import java.util.Arrays;

/**
 * leetcode_88 : Merge Sorted Array.
 * <p>
 * You are given two integer arrays {@code nums1} and {@code nums2}, sorted in
 * non-decreasing order, and two integers {@code m} and {@code n}, representing
 * the number of elements in {@code nums1} and {@code nums2} respectively.
 * <p>
 * Merge {@code nums1} and {@code nums2} into a single array sorted in
 * non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array {@code nums1}.
 * <p>
 * To accommodate this, {@code nums1} has a length of <i>m + n</i>, where the
 * first {@code m} elements denote the elements that should be merged, and the
 * last {@code n} elements are set to 0 and should be ignored. {@code nums2} has
 * a length of {@code n}.
 *
 * <pre>
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1.
 * The 0 is only there to ensure the merge result can fit in nums1.
 * </pre>
 *
 * Constraints:
 * <p>
 * nums1.length == m + n <br>
 * nums2.length == n <br>
 * 0 {@code <=} m, n {@code <=} 200 <br>
 * 1 {@code <=} m + n {@code <=} 200 <br>
 * -10<sup>9</sup> {@code <=} nums1[i], nums2[j] {@code <=} 10<sup>9</sup>
 * <p>
 * <b>Follow up:</b> Can you come up with an algorithm that runs in O(m + n)
 * time?
 *
 * @author RicardoLP
 * @since 2021/11/12
 */
public class MergeSortedArray88 {

    /**
     * Solution1.
     * <p>
     * Put the array {@code nums2} into the end of the array {@code nums1}, and then
     * sort the entire array directly.
     *
     * @param nums1 the array to be merged.
     * @param m the number of elements in {@code nums1}.
     * @param nums2 the array to be merged.
     * @param n the number of elements in {@code nums2}.
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0) {
            System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }

    /**
     * Solution2.
     * <p>
     * Double pointer method.
     * <p>
     * Create a temporary array to avoid overwriting the original data.
     *
     * @param nums1 the array to be merged.
     * @param m the number of elements in {@code nums1}.
     * @param nums2 the array to be merged.
     * @param n the number of elements in {@code nums2}.
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        // Temporary array.
        int[] sorted = new int[m + n];
        int p1 = 0, p2 = 0;
        int cur;

        while (p1 < m || p2 < n) {

            // nums1 all traverse.
            if (p1 == m) {
                cur = nums2[p2++];
                // nums2 all traverse.
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }

            sorted[p1 + p2 - 1] = cur;
        }
        // Write the temporary array to nums1.
        // for (int i = 0; i != m + n; ++i) {
        // nums1[i] = sorted[i];
        // }
        System.arraycopy(sorted, m, nums1, m, n);
    }

    /**
     * Solution3.
     * <p>
     * Reverse double pointer method.
     * <p>
     * Traverse from back to front, and take the larger of the two and place it at
     * the end of {@code nums1} each time.
     *
     * @param nums1 the array to be merged.
     * @param m the number of elements in {@code nums1}.
     * @param nums2 the array to be merged.
     * @param n the number of elements in {@code nums2}.
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {

        // Create tail pointer.
        int tail = m + n - 1;
        int p1 = m - 1, p2 = n - 1;
        int cur;

        while (p1 >= 0 || p2 >= 0) {

            // nums1 all traverse.
            if (p1 == -1) {
                cur = nums2[p2--];
                // nums2 all traverse.
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }

            nums1[tail--] = cur;
        }
    }

    /**
     * Solution4!
     * <p>
     * Reverse double pointer method simplify.
     *
     * @param nums1 the array to be merged.
     * @param m the number of elements in {@code nums1}.
     * @param nums2 the array to be merged.
     * @param n the number of elements in {@code nums2}.
     */
    public void merge4(int[] nums1, int m, int[] nums2, int n) {

        // Initialize the tail pointer.
        int i = m-- + --n;

        while (n >= 0) {
            /*
             * m>=0 && nums1[m] > nums2[n]
             * true -> nums1[i--] = nums1[m--]
             * false -> nums1[i--] = nums2 [n--]
             */
            nums1[i--] = m >= 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }

}
