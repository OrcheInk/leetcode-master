package pers.ricardolp.leetcode.easy;

import java.util.*;

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
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        pers.ricardolp.leetcode.easy.other.TreeNode node1 = new pers.ricardolp.leetcode.easy.other.TreeNode(1);
        pers.ricardolp.leetcode.easy.other.TreeNode node2 = new pers.ricardolp.leetcode.easy.other.TreeNode(2);
        pers.ricardolp.leetcode.easy.other.TreeNode node3 = new pers.ricardolp.leetcode.easy.other.TreeNode(3);
        pers.ricardolp.leetcode.easy.other.TreeNode node4 = new pers.ricardolp.leetcode.easy.other.TreeNode(4);
        pers.ricardolp.leetcode.easy.other.TreeNode node5 = new pers.ricardolp.leetcode.easy.other.TreeNode(5);
        pers.ricardolp.leetcode.easy.other.TreeNode node6 = new pers.ricardolp.leetcode.easy.other.TreeNode(6);
        pers.ricardolp.leetcode.easy.other.TreeNode node7 = new pers.ricardolp.leetcode.easy.other.TreeNode(7);
        pers.ricardolp.leetcode.easy.other.TreeNode node8 = new pers.ricardolp.leetcode.easy.other.TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.right = node6;
        node6.left = node7;
        node6.right = node8;

        BinaryTreeInorderTraversal traversal = new BinaryTreeInorderTraversal();
        List<Integer> list = new ArrayList<>();
        System.out.println(traversal.inorderTraversal3(node1));
        // postorderTraversal(node1);
    }

    // 非递归后序遍历
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            // 查看当前栈顶元素
            node = treeNodeStack.peek();
            // 如果其右子树也为空，或者右子树已经访问
            // 则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                // 否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }

        return list;
    }

    private List<Integer> inorderTraversal1(TreeNode root) {

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

    private List<Integer> inorderTraversal2(TreeNode root) {

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

    private List<Integer> inorderTraversal3(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        TreeNode lastVisit = root;
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 查看当前栈顶元素
            root = stk.peek();
            // 如果其右子树也为空，或者右子树已经访问
            // 则可以直接输出当前节点的值
            if (root.right == null || root.right == lastVisit) {
                res.add(root.val);
                stk.pop();
                lastVisit = root;
                root = null;
            } else {
                // 否则，继续遍历右子树
                root = root.right;
            }
        }
        return res;
    }

}
