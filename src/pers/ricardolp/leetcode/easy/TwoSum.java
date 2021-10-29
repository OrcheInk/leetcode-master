package pers.ricardolp.leetcode.easy;

import java.util.HashMap;

/**
 * leetcode_1 : Two Sum.
 * <p>
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.<br>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.<br>
 * You can return the answer in any order.
 *
 * <pre>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * </pre>
 *
 * Constraints:
 *
 * <pre>
 * {@code
 *  2 <= nums.length <= 104
 *  -109 <= nums[i] <= 109
 *  -109 <= target <= 109
 * }
 * Only one valid answer exists.
 * </pre>
 *
 * Follow-up: Can you come up with an algorithm that is less than
 * O(n<sup>2</sup>) time complexity?
 *
 * @author RicardoLP
 * @since 2021/9/4
 */
public class TwoSum {

    /**
     * Solution1.
     * <p>
     * Use <b>HashMap</b>, when traversing, {@code target-nums[i]} corresponds to
     * {@code i}, stored in the hash table, and at the same time judge whether there
     * is a matching number in the <b>HashMap</b>, if there is, return the current
     * {@code i} and {@code hashMap.get(nums[i])} as the indices.
     *
     * @param nums an array of integers.
     * @param target a target of integers.
     * @return indices of the two numbers such that they add up to target.
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] indices = new int[2];

        // Build a <k, v> hash table.
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                indices[0] = hashMap.get(nums[i]);
                indices[1] = i;
                return indices;
            }
            // Store the result as the key, and the subscript as the value.
            hashMap.put(target - nums[i], i);
        }
        return indices;
    }

    /**
     * Solution2.
     * <p>
     * Use two <b>for</b> loops to traverse, return two subscripts when they add up
     * to the target.
     *
     * @param nums an array of integers.
     * @param target a target of integers.
     * @return indices of the two numbers such that they add up to target.
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] indices = new int[2];

        // Double cycle, cycle limit is (n^2-n)/2.
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

}
