package pers.ricardolp.leetcode.easy;

import java.util.*;

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
     * Iteration post-order traversal.
     * <p>
     * When deciding whether to output the value of the current node, post-order
     * traversal needs to consider whether the left and right subtrees have been
     * traversed, so a cursor {@code lastVisit} needs to be set to record the last
     * visited node.
     * <p>
     * If {@code lastVisit} is equal to the right subtree of the node currently
     * being examined, or the right subtree of the node is {@code null}, indicating
     * that the left and right subtrees of the node have been traversed, the current
     * node can be output, and the {@code lastVisit} can be updated. Otherwise, you
     * need to continue traversing the right subtree of the node.
     *
     * @param root the root of the binary tree.
     * @return the in-order traversal list of binary tree.
     */
    public List<Integer> postorderTraversal1(TreeNode root) {

        // Storage node value.
        List<Integer> res = new ArrayList<>();

        if (root != null) {

            // Storage node.
            Deque<TreeNode> stk = new LinkedList<>();

            // Last visited node.
            TreeNode lastVisit = root;

            while (root != null || !stk.isEmpty()) {

                while (root != null) {
                    stk.push(root);

                    // Traverse the left subtree.
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

                    // Set the current node to null.
                    root = null;

                } else {
                    // Otherwise, continue to traverse the right subtree.
                    root = root.right;
                }
            }
        }
        return res;
    }

    /**
     * Solution2.
     * <p>
     * Reversal of preorder traversal.
     * <p>
     * The approach is similar to the pre-order traversal. <br>
     * First traverse the root node, then the right subtree, and finally the left
     * subtree. <br>
     * Finally, reverse the sequence of the traversal to get the post-order
     * traversal.
     *
     * @param root the root of the binary tree.
     * @return the in-order traversal list of binary tree.
     */
    public List<Integer> postorderTraversal2(TreeNode root) {

        // Store result.
        List<Integer> res = new ArrayList<>();

        if (root != null) {

            // Storage node value.
            Stack<TreeNode> stk = new Stack<>();

            // Add root node.
            stk.push(root);

            while (!stk.isEmpty()) {

                // Last in first out, the pop-stack order is right-> left-> root.
                root = stk.pop();
                res.add(root.val);

                // Add the left child.
                if (root.left != null) {
                    stk.push(root.left);
                }

                // Add the right child.
                if (root.right != null) {
                    stk.push(root.right);
                }
            }
            // Invert the result.
            Collections.reverse(res);
        }
        return res;
    }

    /**
     * Solution3!
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
    public List<Integer> postorderTraversal3(TreeNode root) {

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

                    // Add subtrees other than the root node subtree to the result.
                    addSubtree(res, current.left);

                    // Move the current node to the right.
                    current = current.right;
                }
            } else {
                // If there is no left subtree, go directly to the right subtree.
                current = current.right;
            }
        }
        // Add the subtree of the root node to the result.
        addSubtree(res, root);

        return res;
    }

    /**
     * Invert the subtree and add its nodes to the result.
     *
     * @param res store results.
     * @param node the first node in the subtree.
     */
    private void addSubtree(List<Integer> res, TreeNode node) {

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
