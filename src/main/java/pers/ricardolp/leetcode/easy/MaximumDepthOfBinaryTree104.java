package pers.ricardolp.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_104 : Maximum Depth of Binary Tree.
 * <p>
 * Given the {@code root} of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the {@code root} node down to the farthest leaf node.
 *
 * <pre>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Example 3:
 * Input: root = []
 * Output: 0
 *
 * Example 4:
 * Input: root = [0]
 * Output: 1
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 10<sup>4</sup>]. <br>
 * -100 {@code <=} Node.val {@code <=} 100
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class MaximumDepthOfBinaryTree104 {

    /**
     * Solution1.
     * <p>
     * Depth first search.
     *
     * @param root the root node of the binary tree.
     * @return depth of binary tree.
     */
    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth1(root.left), maxDepth1(root.right)) + 1;
    }

    /**
     * Solution1.
     * <p>
     * Breadth first search.
     *
     * @param root the root node of the binary tree.
     * @return {@code depth} of binary tree.
     */
    public int maxDepth2(TreeNode root) {

        // If the root node is null, the depth of the binary tree is 0.
        int result = 0;

        if (root != null) {

            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int depth = 0;

            while (!queue.isEmpty()) {

                // The number of nodes in the current layer.
                int size = queue.size();

                // traverse the child nodes of the current layer.
                while (size > 0) {

                    TreeNode node = queue.poll();

                    assert node != null;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    size--;
                }
                depth++;
            }
            result = depth;
        }

        return result;
    }

}
