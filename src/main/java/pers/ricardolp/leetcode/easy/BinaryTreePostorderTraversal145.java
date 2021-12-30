package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_145 : Binary Tree Postorder Traversal.
 * <p>
 * Given the {@code root} of a binary tree, return the postorder traversal of
 * its nodes' values.
 *
 * <pre>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
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
 * The number of the nodes in the tree is in the range [0, 100]. <br>
 * -100 {@code <=} Node.val {@code <=} 100
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class BinaryTreePostorderTraversal145 {

    /**
     * Recursive post-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    public void postorderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }

    }

    /**
     * Solution1.
     * <p>
     * Post-order traversal.
     *
     * @param root the root of the binary tree.
     * @return the in-order traversal list of binary tree.
     */
    public List<Integer> postorderTraversal1(TreeNode root) {

        // Storage node value.
        List<Integer> res = new ArrayList<>();
        // Storage node.
        Deque<TreeNode> stk = new LinkedList<>();

        TreeNode lastVisit = root;

        while (root != null || !stk.isEmpty()) {

            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // View the current stack top element.
            root = stk.peek();
            /*
             * If the right subtree is also empty, or the right subtree has been visited,
             * you can directly output the value of the current node.
             */
            assert root != null;
            if (root.right == null || root.right == lastVisit) {

                res.add(root.val);
                stk.pop();
                lastVisit = root;
                root = null;

            } else {
                // Otherwise, continue to traverse the right subtree.
                root = root.right;
            }
        }
        return res;
    }

}
