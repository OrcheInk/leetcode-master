package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_104 : Maximum Depth of Binary Tree.
 *
 * @author RicardoLP
 * @since 2021/11/28
 */
class MaximumDepthOfBinaryTree104Test {

    private MaximumDepthOfBinaryTree104 solution;

    private TreeNode root;

    private int answer = 3;

    @BeforeEach
    public void setUp() {

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

        solution = new MaximumDepthOfBinaryTree104();
    }

    @Test
    void maxDepth1() {
        int result = solution.maxDepth1(root);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void maxDepth2() {
        int result = solution.maxDepth2(root);
        Assertions.assertEquals(answer, result);
    }

}