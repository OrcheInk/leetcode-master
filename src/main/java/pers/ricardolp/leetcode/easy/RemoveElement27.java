package pers.ricardolp.leetcode.easy;

/**
 * leetcode_27 : Remove Element.
 * <p>
 * Given an integer array {@code nums} and an integer {@code val}, remove all
 * occurrences of {@code val} in {@code nums} in-place. The relative order of
 * the elements may be changed.
 * <p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array
 * {@code nums}.
 * <p>
 * More formally, if there are <i>k</i> elements after removing the duplicates,
 * then the first <i>k</i> elements of {@code nums} should hold the final
 * result. It does not matter what you leave beyond the first <i>k</i> elements.
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
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 *}
 *
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * </pre>
 *
 * Constraints:
 * <p>
 * 0 {@code <=} nums.length {@code <=} 100 <br>
 * 0 {@code <=} nums[i] {@code <=} 50 <br>
 * 0 {@code <=} val {@code <=} 100
 *
 * @author RicardoLP
 * @since 2021/11/3
 */
public class RemoveElement27 {

    /**
     * Solution1.
     * <p>
     * Delete the specified value in the array.
     * <p>
     * Use double pointer method.
     *
     * @param nums the integer array to delete the specified element.
     * @param val the specified element to delete in the {@code nums}.
     * @return the length of {@code nums} after deleting the specified element
     *         {@code val}.
     */
    public int removeElement1(int[] nums, int val) {

        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {

            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

        }
        return slow;
    }

    /**
     * Solution2 Optimization.
     * <p>
     * Delete the specified value in the array.
     * <p>
     * Use double pointer method.
     *
     * @param nums the integer array to delete the specified element.
     * @param val the specified element to delete in the {@code nums}.
     * @return the length of {@code nums} after deleting the specified element
     *         {@code val}.
     */
    public int removeElement2(int[] nums, int val) {

        int left = 0;
        int right = nums.length;

        /*
         * When the left pointer and the right pointer coincide,
         * the left and right pointers traverse all the elements in the array.
         */
        while (left < right) {

            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }

        }
        return left;
    }

}
