package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_110 : Balanced Binary Tree.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
class BalancedBinaryTree110Test {

    private BalancedBinaryTree110 solution;

    private TreeNode root;

    private boolean answer = true;

    @BeforeEach
    public void setUp() {

        solution = new BalancedBinaryTree110();

        // 3, 9, 20, null, null, 15, 7
        root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
    }

    @Test
    void isBalanced1() {
        boolean result = solution.isBalanced1(root);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void isBalanced2() {
        boolean result = solution.isBalanced2(root);
        Assertions.assertEquals(answer, result);
    }

}