package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
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
    private List<Integer> result;

    private List<Integer> preOrderAnswer;
    private List<Integer> inOrderAnswer;
    private List<Integer> postOrderAnswer;

    @BeforeEach
    public void setUp() {

        root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;

        result = new ArrayList<>();

        preOrderAnswer = new ArrayList<>(Arrays.asList(0, 1, 3, 2, 4));
        inOrderAnswer = new ArrayList<>(Arrays.asList(3, 1, 0, 2, 4));
        postOrderAnswer = new ArrayList<>(Arrays.asList(3, 1, 4, 2, 0));

        solution = new BinaryTreeInorderTraversal94();
    }

    @Test
    void preOrderTraversal() {
        solution.preOrderTraversal(root, result);
        Assertions.assertEquals(preOrderAnswer, result);
    }

    @Test
    void inOrderTraversal() {
        solution.inOrderTraversal(root, result);
        Assertions.assertEquals(inOrderAnswer, result);
    }

    @Test
    void postOrderTraversal() {
        solution.postOrderTraversal(root, result);
        Assertions.assertEquals(postOrderAnswer, result);
    }

    @Test
    void testPreOrderTraversal() {
        List<Integer> result = solution.preOrderTraversal(root);
        Assertions.assertEquals(preOrderAnswer, result);
    }

    @Test
    void inorderTraversal1() {
        List<Integer> result = solution.inorderTraversal1(root);
        Assertions.assertEquals(inOrderAnswer, result);
    }

    @Test
    void inorderTraversal2() {
        List<Integer> result = solution.inorderTraversal2(root);
        Assertions.assertEquals(inOrderAnswer, result);
    }

    @Test
    void testPostOrderTraversal() {
        List<Integer> result = solution.postOrderTraversal(root);
        Assertions.assertEquals(postOrderAnswer, result);
    }

}