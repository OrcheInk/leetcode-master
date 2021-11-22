package pers.ricardolp.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_101 : Symmetric Tree.
 * <p>
 * Given the {@code root} of a binary tree, check whether it is a mirror of
 * itself (i.e., symmetric around its center).
 *
 * <pre>
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 1000]. <br>
 * -100 {@code <=} Node.val {@code <=} 100
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class SymmetricTree101 {

    /**
     * Solution1.
     * <p>
     * Breadth-first search.
     *
     * @param root the root node of the binary tree.
     * @return {@code true} if the binary tree is a symmetric binary
     *         tree,{@code false} otherwise.
     */
    public boolean isSymmetric1(TreeNode root) {
        boolean result = true;

        if (root != null) {

            Deque<TreeNode> queqe = new LinkedList<>();

            queqe.offer(root.left);
            queqe.offer(root.right);

            while (!queqe.isEmpty()) {

                TreeNode node1 = queqe.poll();
                TreeNode node2 = queqe.poll();

                if (node1 == null && node2 == null) {
                    continue;
                }

                if (node1 == null || node2 == null || node1.val != node2.val) {
                    result = false;
                    break;
                }

                queqe.offer(node1.left);
                queqe.offer(node2.right);
                queqe.offer(node1.right);
                queqe.offer(node2.left);

            }
        }
        return result;
    }

    /**
     * Solution2.
     * <p>
     * Depth-first search.
     *
     * @param root the root node of the binary tree.
     * @return {@code true} if the binary tree is a symmetric binary
     *         tree,{@code false} otherwise.
     */
    public boolean isSymmetric2(TreeNode root) {
        return isSame(root.left, root.right);
    }

    /**
     * Determine whether the current binary tree is a symmetric binary tree.
     * <p>
     *
     * @param node1 the node of left subtree.
     * @param node2 the node of right subtree.
     * @return {@code true} if the binary tree is a symmetric binary
     *         tree,{@code false} otherwise.
     */
    private boolean isSame(TreeNode node1, TreeNode node2) {

        boolean result = false;

        if (node1 == null && node2 == null) {
            result = true;
        } else if (node1 != null && node2 != null && node1.val == node2.val) {

            result = isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
        }

        return result;
    }

}
