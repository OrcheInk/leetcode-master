package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_144 : Binary Tree Preorder Traversal.
 *
 * @author RicardoLP
 * @since 2021/12/31
 */
class BinaryTreePreorderTraversal144Test {

    private BinaryTreePreorderTraversal144 solution;

    private TreeNode root;

    private List<Integer> list;
    private String answer;

    @BeforeEach
    public void setUp() {

        // 1, 2, 3, null, 4, null, null, 5, 6
        root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        list = new ArrayList<>();

        answer = "[1, 2, 4, 5, 6, 3]";

        solution = new BinaryTreePreorderTraversal144();
    }

    @Test
    void preorderTraversal() {
        solution.preorderTraversal(root, list);
        Assertions.assertEquals(answer, list.toString());
    }

    @Test
    void preorderTraversal1() {
        List<Integer> result = solution.preorderTraversal1(root);
        Assertions.assertEquals(answer, result.toString());
    }

}