package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_112 : Path Sum.
 *
 * @author RicardoLP
 * @since 2021/12/16
 */
class PathSum112Test {

    private PathSum112 solution;

    private int targetSum = 22;
    private TreeNode root;

    @BeforeEach
    public void setUp() {

        // 5, 4, 8, 11, null, 13, 4, 7, 2,null, null, null, 8
        root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);

        root.left = node1;
        root.right = node2;

        node1.left = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        node5.right = node8;

        solution = new PathSum112();
    }

    @Test
    void hasPathSum1() {
        boolean result = solution.hasPathSum1(root, targetSum);
        Assertions.assertTrue(result);
    }

    @Test
    void hasPathSum2() {
        boolean result = solution.hasPathSum2(root, targetSum);
        Assertions.assertTrue(result);
    }

}