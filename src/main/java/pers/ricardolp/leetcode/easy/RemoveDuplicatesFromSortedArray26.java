package pers.ricardolp.leetcode.easy;

/**
 * leetcode_26 : Remove Duplicates from Sorted Array.
 * <p>
 * Given an integer array {@code nums} sorted in non-decreasing order, remove
 * the duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * {@code nums}. More formally, if there are <i>k</i> elements after removing
 * the duplicates, then the first <i>k</i> elements of {@code nums} should hold
 * the final result. It does not matter what you leave beyond the first <i>k</i>
 * elements.
 * <p>
 * Return <i>k</i> after placing the final result in the first <i>k</i> slots of
 * {@code nums}.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying
 * the input array in-place with O(1) extra memory.
 * <p>
 * <b>Custom Judge:</b>
 * <p>
 * The judge will test your solution with the following code:
 *
 * <pre>
 * {@code
 * // Input array.
 * int[] nums = [...];
 * // The expected answer with correct length.
 * int[] expectedNums = [...];
 *
 * // Calls your implementation.
 * int k = removeDuplicates(nums);
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *      assert nums[i] == expectedNums[i];
 * }
 * }
 *
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * Constraints:
 * <p>
 * 0 {@code <=} nums.length {@code <}= 3 * 10<sup>4</sup> <br>
 * -100 {@code <=} nums[i] {@code <=} 100 <br>
 * {@code nums} is sorted in non-decreasing order.
 *
 * @author RicardoLP
 * @since 2021/11/2
 */
public class RemoveDuplicatesFromSortedArray26 {

    /**
     * Solution1.
     * <p>
     * Delete duplicate elements by double pointer method.
     *
     * @param nums the integer array to be deduplicated.
     * @return the number of distinct elements in {@code nums}.
     */
    public int removeDuplicates1(int[] nums) {

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[slow] == nums[fast]) {
                continue;
            }

            slow++;
            nums[slow] = nums[fast];
        }
        return ++slow;
    }

    /**
     * Solution2.
     * <p>
     * Delete duplicate elements by double pointer method.
     *
     * @param nums the integer array to be deduplicated.
     * @return the number of distinct elements in {@code nums}.
     */
    public int removeDuplicates2(int[] nums) {

        int slow = 1;

        for (int fast = 1; fast < nums.length; fast++) {

            if (nums[slow - 1] != nums[fast]) {
                nums[slow++] = nums[fast];
            }

        }
        return slow;
    }

    /**
     * Solution3.
     * <p>
     * Replace the repeated elements in the array before rearranging them.
     *
     * @param nums the integer array to be deduplicated.
     * @return the number of distinct elements in {@code nums}.
     */
    public int removeDuplicates3(int[] nums) {

        int flag = 0;
        int limit = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] == nums[i + 1]) {
                nums[i] = limit;
            }

        }

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != limit) {
                nums[flag] = nums[i];
                flag++;
            }

        }
        return flag;
    }

}
