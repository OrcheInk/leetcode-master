package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_100 : Same Tree.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class SameTree100Test {

    private SameTree100 solution;

    private TreeNode p;
    private TreeNode q;

    @BeforeEach
    public void setUp() {

        p = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        p.left = node1;
        p.right = node2;

        q = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);

        q.left = node3;
        q.right = node4;

        solution = new SameTree100();
    }

    @Test
    void isSameTree1() {
        boolean result = solution.isSameTree1(p, q);
        Assertions.assertTrue(result);
    }

    @Test
    void isSameTree2() {
        boolean result = solution.isSameTree2(p, q);
        Assertions.assertTrue(result);
    }

    @Test
    void isSameTree3() {
        boolean result = solution.isSameTree3(p, q);
        Assertions.assertTrue(result);
    }

    @Test
    void isSameTree4() {
        boolean result = solution.isSameTree4(p, q);
        Assertions.assertTrue(result);
    }

    @Test
    void isSameTree5() {
        boolean result = solution.isSameTree5(p, q);
        Assertions.assertTrue(result);
    }

}