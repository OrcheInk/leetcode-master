package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_111 : Minimum Depth of Binary Tree.
 *
 * @author RicardoLP
 * @since 2021/11/19
 */
class MinimumDepthOfBinaryTree111Test {

    private MinimumDepthOfBinaryTree111 solution;

    private TreeNode root;

    private int answer = 5;

    @BeforeEach
    public void setUp() {

        // 2, null, 3, null, 4, 5, null, 6
        root = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(6);

        root.right = node1;
        node1.right = node2;
        node2.left = node3;
        node3.left = node4;

        solution = new MinimumDepthOfBinaryTree111();
    }

    @Test
    void minDepth1() {
        int result = solution.minDepth1(root);
        Assertions.assertEquals(answer, result);
    }

    @Test
    void minDepth2() {
        int result = solution.minDepth2(root);
        Assertions.assertEquals(answer, result);
    }

}