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

    /**
     * Solution2!
     * <p>
     * Morris Post-order traversal.
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
     * @return the post-order traversal list of binary tree.
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        // Store results.
        List<Integer> res = new ArrayList<>();

        // Storage node value.
        TreeNode current = root, predecessor;

        while (current != null) {

            if (current.left != null) {

                /*
                 * The predecessor node means that the current root node takes one step to the
                 * left, and then keeps going to the right until it cannot go.
                 */
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                /*
                 * Let the right pointer of predecessor point to root and continue to traverse
                 * the left subtree.
                 */
                if (predecessor.right == null) {

                    predecessor.right = current;
                    current = current.left;

                    /*
                     * Explain that the left subtree has been visited,
                     * we need to disconnect the link.
                     */
                } else {

                    predecessor.right = null;

                    // Add the subtree node to the result.
                    addSubtree(res, current.left);

                    // Move the current node to the right.
                    current = current.right;
                }
            } else {
                // If there is no left subtree, go directly to the right subtree.
                current = current.right;
            }
        }
        // Add the subtree node to the result.
        addSubtree(res, root);

        return res;
    }

    /**
     * Invert the subtree and add its nodes to the result.
     *
     * @param res store results.
     * @param node the first node in the subtree.
     */
    public void addSubtree(List<Integer> res, TreeNode node) {

        // Record the number of nodes added.
        int count = 0;

        // Add the node of the current subtree to the list.
        while (node != null) {

            count++;

            res.add(node.val);
            node = node.right;
        }

        // Calculate the index of the leftmost and rightmost node added.
        int left = res.size() - count, right = res.size() - 1;

        // Reverse the order of added nodes.
        while (left < right) {

            int temp = res.get(left);

            res.set(left, res.get(right));
            res.set(right, temp);

            // Move index.
            left++;
            right--;
        }

    }

}
