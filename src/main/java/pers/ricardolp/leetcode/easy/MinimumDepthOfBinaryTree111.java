package pers.ricardolp.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_111 : Minimum Depth of Binary Tree.
 * <p>
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the
 * {@code root} node down to the nearest leaf node.
 * <p>
 * <b>Note:</b> A leaf is a node with no children.
 *
 * <pre>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 *
 * Example 2:
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 10<sup>5</sup>]. <br>
 * -1000 {@code <=} Node.val {@code <=} 1000
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class MinimumDepthOfBinaryTree111 {

    /**
     * Solution1.
     * <p>
     * Depth-first search method.
     *
     * @param root the root node of the binary tree.
     * @return the minimum depth of the binary tree.
     */
    public int minDepth1(TreeNode root) {

        int result;

        if (root == null) {
            result = 0;

            // empty node does not perform calculations.
        } else if (root.left == null && root.right != null) {
            result = minDepth1(root.right) + 1;

            // empty node does not perform calculations.
        } else if (root.right == null && root.left != null) {
            result = minDepth1(root.left) + 1;

            /*
             * If the left and right node does not empty,
             * select the one with the smallest depth.
             */
        } else {
            result = Math.min(minDepth1(root.left), minDepth1(root.right)) + 1;
        }

        return result;
    }

    /**
     * Solution2.
     * <p>
     * Breadth-first search method.
     *
     * @param root the root node of the binary tree.
     * @return the minimum depth of the binary tree.
     */
    public int minDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        int depth = 1;

        while (!deque.isEmpty()) {

            int size = deque.size();

            for (int i = 0; i < size; i++) {

                TreeNode cur = deque.poll();

                assert cur != null;
                if (cur.right == null && cur.left == null) {
                    return depth;
                }

                // empty node does not perform calculations.
                if (cur.left != null) {
                    deque.offer(cur.left);
                }

                // empty node does not perform calculations.
                if (cur.right != null) {
                    deque.offer(cur.right);
                }

            }
            depth++;
        }
        return depth;
    }

}
