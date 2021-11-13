package pers.ricardolp.leetcode.easy;

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
        traversal.inorderTraversal(node1);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val);
            inorderTraversal(root.right);
        }

        return null;
    }
}
