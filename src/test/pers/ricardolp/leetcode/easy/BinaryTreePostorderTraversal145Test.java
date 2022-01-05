package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_145 : Binary Tree Postorder Traversal.
 *
 * @author RicardoLP
 * @since 2021/12/31
 */
class BinaryTreePostorderTraversal145Test {

    private BinaryTreePostorderTraversal145 solution;

    private TreeNode root;

    private List<Integer> list;
    private String answer;

    @BeforeEach
    public void setUp() {

        // 1, 2, 3, 4, null, null, 5, null, 6, 7, 8
        root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.left = node6;
        node5.right = node7;

        list = new ArrayList<>();

        answer = "[7, 8, 6, 4, 2, 5, 3, 1]";

        solution = new BinaryTreePostorderTraversal145();
    }

    @Test
    void postorderTraversal() {
        solution.postorderTraversal(root, list);
        Assertions.assertEquals(answer, list.toString());
    }

    @Test
    void postorderTraversal1() {
        List<Integer> result = solution.postorderTraversal1(root);
        Assertions.assertEquals(answer, result.toString());
    }

    @Test
    void postorderTraversal2() {
        List<Integer> result = solution.postorderTraversal2(root);
        Assertions.assertEquals(answer, result.toString());
    }

    @Test
    void postorderTraversal3() {
        List<Integer> result = solution.postorderTraversal3(root);
        Assertions.assertEquals(answer, result.toString());
    }

}