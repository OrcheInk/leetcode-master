package pers.ricardolp.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_112 : Path Sum.
 * <p>
 * Given the {@code root} of a binary tree and an integer {@code targetSum},
 * return {@code true} if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals {@code targetSum}.
 * <p>
 * A leaf is a node with no children.
 *
 * <pre>
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 *
 * Example 3:
 * Input: root = [1,2], targetSum = 0
 * Output: false
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000]. <br>
 * -1000 {@code <=} Node.val {@code <=} 1000 <br>
 * -1000 {@code <=} targetSum {@code <=} 1000
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class PathSum112 {

    /**
     * Solution1.
     * <p>
     * Recursion.
     *
     * @param root the root of a binary tree.
     * @param targetSum the sum of the numbers on the path.
     * @return {@code true} if the tree has a root-to-leaf path such that adding up
     *         all the values along the path equals {@code targetSum}.
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {

            return targetSum - root.val == 0;
        }

        return hasPathSum1(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    /**
     * Solution2.
     * <p>
     * Breadth first search.
     *
     * @param root the root of a binary tree.
     * @param targetSum the sum of the numbers on the path.
     * @return {@code true} if the tree has a root-to-leaf path such that adding up
     *         all the values along the path equals {@code targetSum}.
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        // New queue.
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();

        queNode.offer(root);
        queVal.offer(root.val);

        while (!queNode.isEmpty()) {

            TreeNode now = queNode.poll();

            // noinspection ConstantConditions
            int result = queVal.poll();

            // If the current node is empty, judge whether the result is targetSum.
            if (now.left == null && now.right == null) {

                if (result == targetSum) {
                    return true;
                }
                continue;

            }

            if (now.left != null) {

                queNode.offer(now.left);

                // If the left child node is not empty, it will be added to the result.
                queVal.offer(now.left.val + result);

            }

            if (now.right != null) {

                queNode.offer(now.right);

                // If the right child node is not empty, it will be added to the result.
                queVal.offer(now.right.val + result);

            }
        }

        return false;
    }

}
