package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_94 : Binary Tree Inorder Traversal.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
class BinaryTreeInorderTraversal94Test {

    private BinaryTreeInorderTraversal94 solution;

    private TreeNode root;

    private List<Integer> list;
    private String answer;

    @BeforeEach
    public void setUp() {

        // 0, 1, 2, 3, null, null, 4
        root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        list = new ArrayList<>();

        answer = "[3, 1, 0, 2, 4]";

        solution = new BinaryTreeInorderTraversal94();
    }

    @Test
    void inOrderTraversal() {
        solution.inOrderTraversal(root, list);
        Assertions.assertEquals(answer, list.toString());
    }

    @Test
    void inorderTraversal1() {
        List<Integer> result = solution.inorderTraversal1(root);
        Assertions.assertEquals(answer, result.toString());
    }

    @Test
    void inorderTraversal2() {
        List<Integer> result = solution.inorderTraversal2(root);
        Assertions.assertEquals(answer, result.toString());
    }

}