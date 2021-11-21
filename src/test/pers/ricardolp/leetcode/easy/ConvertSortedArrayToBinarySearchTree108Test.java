package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_108 : Convert Sorted Array to Binary Search Tree.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
@PrepareForTest(ConvertSortedArrayToBinarySearchTree108.class)
class ConvertSortedArrayToBinarySearchTree108Test {

    private ConvertSortedArrayToBinarySearchTree108 solution;
    private BinaryTreeInorderTraversal94 traversal;
    private List<Integer> list;
    private int[] nums = {-10, -3, 0, 5, 9};

    @BeforeEach
    public void setUp() throws Exception {

        Random mockedRandom = PowerMockito.mock(Random.class);
        PowerMockito.whenNew(Random.class).withNoArguments().thenReturn(mockedRandom);
        PowerMockito.doReturn(0).when(mockedRandom).nextInt(2);

        solution = new ConvertSortedArrayToBinarySearchTree108();
        traversal = new BinaryTreeInorderTraversal94();

    }

    @Test
    void sortedArrayToBST1() {

        List<Integer> answer = new ArrayList<>(Arrays.asList(0, -10, -3, 5, 9));

        TreeNode result = solution.sortedArrayToBST1(nums);
        list = traversal.preOrderTraversal(result);

        Assertions.assertEquals(answer, list);
    }

    @Test
    void sortedArrayToBST2() {

        List<Integer> answer = new ArrayList<>(Arrays.asList(0, -3, -10, 9, 5));

        TreeNode result = solution.sortedArrayToBST2(nums);
        list = traversal.preOrderTraversal(result);

        Assertions.assertEquals(answer, list);
    }

    @Test
    void sortedArrayToBST3() {

        TreeNode result = solution.sortedArrayToBST3(nums);
        list = traversal.preOrderTraversal(result);

        System.out.println(list);
    }

}