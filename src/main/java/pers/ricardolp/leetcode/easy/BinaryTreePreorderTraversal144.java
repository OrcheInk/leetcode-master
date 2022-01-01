package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_144 : Binary Tree Preorder Traversal.
 * <p>
 * Given the {@code root} of a binary tree, return the preorder traversal of its
 * nodes' values.
 *
 * <pre>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100]. <br>
 * -100 {@code <=} Node.val {@code <=} 100
 * <p>
 * <b>Follow up:</b> Recursive solution is trivial, could you do it iteratively?
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class BinaryTreePreorderTraversal144 {

    /**
     * Recursive pre-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    public void preorderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }

    }

    /**
     * Solution1.
     * <p>
     * Pre-order traversal.
     *
     * @param root the root of the binary tree.
     * @return the pre-order traversal list of binary tree.
     */
    public List<Integer> preorderTraversal1(TreeNode root) {

        // Storage result.
        List<Integer> res = new ArrayList<>();

        if (root != null) {

            // Storage node.
            Deque<TreeNode> stk = new LinkedList<>();

            while (root != null || !stk.isEmpty()) {

                // Traverse the left subtree.
                while (root != null) {
                    stk.push(root);
                    res.add(root.val);
                    root = root.left;
                }

                // Pop up the root node.
                root = stk.pop();

                // Traverse the right subtree.
                root = root.right;
            }
        }
        return res;
    }

    /**
     * Solution2!
     * <p>
     * Morris Pre-order traversal.
     * <p>
     * Assuming the currently traversed node is <i>x</i>.
     * <p>
     * Point the rightmost node in the left subtree of <i>x</i> to <i>x</i>, so that
     * after the traversal of the left subtree is completed.
     * <p>
     * we go back to <i>x</i> through this point, and we can know us through this
     * point The left subtree has been traversed.
     * <p>
     * And the stack is no longer maintained, which saves the space complexity of
     * the stack.
     *
     * @param root the root of the binary tree.
     * @return the pre-order traversal list of binary tree.
     */
    public List<Integer> preorderTraversal2(TreeNode root) {

        // Storage result.
        List<Integer> res = new ArrayList<>();

        // Predecessor node of in-order traversal.
        TreeNode predecessor;

        while (root != null) {

            if (root.left != null) {

                /*
                 * The predecessor node means that the current root node takes one step to the
                 * left, and then keeps going to the right until it cannot go.
                 */
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }

                /*
                 * Let the right pointer of predecessor point to root and continue to traverse
                 * the left subtree.
                 */
                if (predecessor.right == null) {

                    predecessor.right = root;

                    res.add(root.val);
                    root = root.left;
                }
                /*
                 * Explain that the left subtree has been visited,
                 * we need to disconnect the link.
                 */
                else {

                    predecessor.right = null;

                    // Move the current node to the right.
                    root = root.right;
                }
            }
            // If there is no left subtree, go directly to the right subtree.
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}
