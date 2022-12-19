package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_101 : Symmetric Tree.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class SymmetricTree101Test {

    private SymmetricTree101 solution;

    private TreeNode root;

    @BeforeEach
    public void setUp() {

        // 1, 2, 2, 3, 4, 4, 3
        root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        solution = new SymmetricTree101();
    }

    @Test
    void isSymmetric1() {
        boolean result = solution.isSymmetric1(root);
        Assertions.assertTrue(result);
    }

    @Test
    void isSymmetric2() {
        boolean result = solution.isSymmetric2(root);
        Assertions.assertTrue(result);
    }

}