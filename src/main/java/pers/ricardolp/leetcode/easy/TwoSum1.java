package pers.ricardolp.leetcode.easy;

import java.util.HashMap;

/**
 * leetcode_1 : Two Sum.
 * <p>
 * Given an array of integers {@code nums} and an integer {@code target}, return
 * indices of the two numbers such that they add up to {@code target}.
 * <p>
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
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
 * <p>
 * 2 {@code <=} nums.length {@code <=} 10<sup>4</sup> <br>
 * -10<sup>9</sup> {@code <=} nums[i] {@code <=} 10<sup>9</sup> <br>
 * -10<sup>9</sup> {@code <=} target {@code <=} 10<sup>9</sup> <br>
 * Only one valid answer exists.
 * <p>
 * <b>Follow-up:</b> Can you come up with an algorithm that is less than
 * O(n<sup>2</sup>) time complexity?
 *
 * @author RicardoLP
 * @since 2021/9/4
 */
public class TwoSum1 {

    /**
     * Solution1.
     * <p>
     * Use HashMap, when traversing, {@code target-nums[i]} corresponds to
     * {@code i}, stored in the hash table, and at the same time judge whether there
     * is a matching number in the HashMap.
     * <p>
     * If there is, return the current {@code i} and {@code hashMap.get(nums[i])} as
     * the indices.
     *
     * @param nums the integer array to find the subscripts of the elements whose
     *            addition is equal to target.
     * @param target the target of integer.
     * @return the indices of the two numbers such that they add up to
     *         {@code target}.
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = null;

        int[] indices = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                indices[0] = hashMap.get(nums[i]);
                indices[1] = i;
                result = indices;
                break;
            }
            // Store the result as the key, and the subscript as the value.
            hashMap.put(target - nums[i], i);
        }
        if (result == null) {
            result = indices;
        }
        return result;
    }

    /**
     * Solution2.
     * <p>
     * Use two for loops to traverse, return two subscripts when they add up to the
     * {@code target}.
     *
     * @param nums the integer array to find the subscripts of the elements whose
     *            addition is equal to target.
     * @param target the target of integer.
     * @return the indices of the two numbers such that they add up to
     *         {@code target}.
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = null;

        int[] indices = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length - 1; j > i; j--) {

                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    result = indices;
                    break;
                }

            }
            if (result != null) {
                break;
            }
        }
        if (result == null) {
            result = indices;
        }
        return result;
    }

}
