package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_94 : Binary Tree Inorder Traversal.
 * <p>
 * Given the {@code root} of a binary tree, return the inorder traversal of its
 * nodes' values.
 *
 * <pre>
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Example 2:
 * Input: root = []
 * Output: []
 *
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 *
 * Example 4:
 * Input: root = [1,2]
 * Output: [2,1]
 *
 * Example 5:
 * Input: root = [1,null,2]
 * Output: [1,2]
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 100]. <br>
 * -100 {@code <=} Node.val {@code <=} 100
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class BinaryTreeInorderTraversal94 {

    /**
     * Recursive pre-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    public void preOrderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }

    }

    /**
     * Recursive in-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    public void inOrderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }

    }

    /**
     * Recursive post-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    public void postOrderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            postOrderTraversal(root.left, list);
            postOrderTraversal(root.right, list);
            list.add(root.val);
        }

    }

    /**
     * Pre-order traversal.
     *
     * @param root the root of the binary tree.
     * @return the pre-order traversal list of binary tree.
     */
    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
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
        return res;
    }

    /**
     * Solution1.
     * <p>
     * In-order traversal.
     *
     * @param root the root of the binary tree.
     * @return the in-order traversal list of binary tree.
     */
    public List<Integer> inorderTraversal1(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (root != null || !stk.isEmpty()) {

            // Traverse the left subtree.
            while (root != null) {
                stk.push(root);
                root = root.left;
            }

            // Pop up the root node.
            root = stk.pop();
            res.add(root.val);

            // Traverse the right subtree.
            root = root.right;
        }
        return res;
    }

    /**
     * Solution2!
     * <p>
     * Morris In-order traversal.
     * <p>
     * Assuming that the currently traversed node is <i>x</i>.
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
     * @return the in-order traversal list of binary tree.
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
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
                    root = root.left;
                }
                /*
                 * Explain that the left subtree has been visited,
                 * we need to disconnect the link.
                 */
                else {
                    res.add(root.val);
                    predecessor.right = null;
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

    /**
     * Post-order traversal.
     *
     * @param root the root of the binary tree.
     * @return the in-order traversal list of binary tree.
     */
    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
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
