package pers.ricardolp.leetcode.easy;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_110 : Balanced Binary Tree.
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * <p>
 * For this problem, a height-balanced binary tree is defined as: <blockquote> A
 * binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1. </blockquote>
 *
 * <pre>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 *
 * Example 3:
 * Input: root = []
 * Output: true
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 5000]. <br>
 * -10<sup>4</sup> {@code <=} Node.val {@code <=} 10<sup>4</sup>
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class BalancedBinaryTree110 {

    /**
     * Solution1.
     * <p>
     * Top-down recursion.
     *
     * @param root the root node of the binary tree.
     * @return {@code true} if it is a height-balanced binary tree, {@code false}
     *         otherwise.
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(topDownHeight(root.left) - topDownHeight(root.right)) <= 1 && isBalanced1(root.left)
            && isBalanced1(root.right);
    }

    /**
     * For the current traversed node, first calculate the height of the left and
     * right subtrees. <br>
     * If the height difference between the left and right subtrees does not exceed
     * 1, then recursively traverse the left and right child nodes. <br>
     * And judge whether the left subtree and the right subtree are balanced.
     *
     * @param root the root node of the binary tree.
     * @return the height of the node.
     */
    private int topDownHeight(TreeNode root) {

        int result = 0;

        if (root != null) {
            result = Math.max(topDownHeight(root.left), topDownHeight(root.right)) + 1;
        }
        return result;
    }

    /**
     * Solution2.
     * <p>
     * Bottom-up recursion.
     *
     * @param root the root node of the binary tree.
     * @return {@code true} if it is a height-balanced binary tree, {@code false}
     *         otherwise.
     */
    public boolean isBalanced2(TreeNode root) {
        return bottomUpHeight(root) != -1;
    }

    /**
     * For the node currently traversed, first recursively judge whether the left
     * and right subtrees are balanced, and then judge whether the subtree rooted at
     * the current node is balanced.
     *
     * @param root the root node of the binary tree.
     * @return the height of the current subtree, if this subtree is balanced,
     *         {@code -1} otherwise.
     */
    private int bottomUpHeight(TreeNode root) {

        int result;

        if (root == null) {
            result = 0;
        } else {

            int leftHeight = bottomUpHeight(root.left);
            int rightHeight = bottomUpHeight(root.right);

            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                result = -1;
            } else {
                result = Math.abs(leftHeight - rightHeight) + 1;
            }
        }

        return result;
    }

}
