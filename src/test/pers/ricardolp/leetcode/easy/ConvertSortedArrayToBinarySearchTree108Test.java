package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * Summary description
 * <p>
 * Detail description
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
class ConvertSortedArrayToBinarySearchTree108Test {

    private ConvertSortedArrayToBinarySearchTree108 solution;
    private BinaryTreeInorderTraversal94 traversal;
    private List<Integer> list;
    private int[] nums = {-10, -3, 0, 5, 9};

    @BeforeEach
    public void initialize() {
        solution = new ConvertSortedArrayToBinarySearchTree108();
        traversal = new BinaryTreeInorderTraversal94();
    }

    @Test
    void sortedArrayToBST1() {

        List<Integer> answer = new ArrayList<>(Arrays.asList(-10, -3, 0, 5, 9));

        TreeNode result = solution.sortedArrayToBST1(nums);
        list = traversal.inorderTraversal1(result);

        Assertions.assertEquals(answer, list);
    }

    @Test
    void sortedArrayToBST2() {
        TreeNode result = solution.sortedArrayToBST2(nums);
        list = traversal.inorderTraversal1(result);
        System.out.println(list);
    }

    @Test
    void sortedArrayToBST3() {}
}