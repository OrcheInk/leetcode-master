package pers.ricardolp.leetcode.easy;

import java.util.Random;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_108 : Convert Sorted Array to Binary Search Tree.
 * <p>
 * Given an integer array {@code nums} where the elements are sorted in
 * ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 *
 * <pre>
 * Example 1:
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} nums.length {@code <=} 10<sup>4</sup> <br>
 * -10<sup>4</sup> {@code <=} nums[i] {@code <=} 10<sup>4</sup> <br>
 * {@code nums} is sorted in a strictly increasing order.
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class ConvertSortedArrayToBinarySearchTree108 {

    private Random rand = new Random();

    /**
     * Solution1.
     * <p>
     * Always choose the number to the left of the middle position as the root node.
     *
     * @param nums the ascending array.
     * @return the height-balanced binary search tree.
     */
    public TreeNode sortedArrayToBst1(int[] nums) {
        return constructor1(nums, 0, nums.length - 1);
    }

    /**
     * Solution2.
     * <p>
     * Always choose the number to the right of the middle position as the root
     * node.
     *
     * @param nums the ascending array.
     * @return the height-balanced binary search tree.
     */
    public TreeNode sortedArrayToBst2(int[] nums) {
        return constructor2(nums, 0, nums.length - 1);
    }

    /**
     * Solution3.
     * <p>
     * Choose any middle position number as the root node.
     *
     * @param nums the ascending array.
     * @return the height-balanced binary search tree.
     */
    public TreeNode sortedArrayToBst3(int[] nums) {
        return constructor3(nums, 0, nums.length - 1);
    }

    /**
     * Construct a height-balanced binary search tree.
     *
     * @param nums the ascending array.
     * @param left {@code 0}, The start index of the array.
     * @param right s{@code nums.length - 1}, the end index of the array.
     * @return the height-balanced binary search tree.
     */
    private TreeNode constructor1(int[] nums, int left, int right) {

        TreeNode result = null;

        if (left <= right) {

            int mid = left + ((right - left) >> 1);

            TreeNode node = new TreeNode(nums[mid]);
            node.left = constructor1(nums, left, mid - 1);
            node.right = constructor1(nums, mid + 1, right);

            result = node;
        }

        return result;
    }

    /**
     * Construct a height-balanced binary search tree.
     *
     * @param nums the ascending array.
     * @param left {@code 0}, The start index of the array.
     * @param right {@code nums.length - 1}, the end index of the array.
     * @return the height-balanced binary search tree.
     */
    private TreeNode constructor2(int[] nums, int left, int right) {

        TreeNode result = null;

        if (left <= right) {

            int mid = left + ((right - left + 1) >> 1);

            TreeNode node = new TreeNode(nums[mid]);
            node.left = constructor2(nums, left, mid - 1);
            node.right = constructor2(nums, mid + 1, right);

            result = node;
        }

        return result;
    }

    /**
     * Construct a height-balanced binary search tree.
     *
     * @param nums the ascending array.
     * @param left {@code 0}, The start index of the array.
     * @param right {@code nums.length - 1}, the end index of the array.
     * @return the height-balanced binary search tree.
     */
    private TreeNode constructor3(int[] nums, int left, int right) {

        TreeNode result = null;

        if (left <= right) {

            // .nextInt -> the upper bound (exclusive), must be positive.
            int random = rand.nextInt(2);
            int mid = left + ((right - left + random) >> 1);

            TreeNode node = new TreeNode(nums[mid]);
            node.left = constructor3(nums, left, mid - 1);
            node.right = constructor3(nums, mid + 1, right);

            result = node;
        }

        return result;
    }
}
