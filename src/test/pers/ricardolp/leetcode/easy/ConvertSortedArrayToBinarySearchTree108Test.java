package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_108 : Convert Sorted Array to Binary Search Tree.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
@ExtendWith(MockitoExtension.class)
class ConvertSortedArrayToBinarySearchTree108Test {

    private ConvertSortedArrayToBinarySearchTree108 solution;
    private BinaryTreePreorderTraversal144 traversal;

    private List<Integer> list;
    private int[] nums = {-10, -3, 0, 5, 9};

    private List<Integer> answer1 = new ArrayList<>(Arrays.asList(0, -10, -3, 5, 9));
    private List<Integer> answer2 = new ArrayList<>(Arrays.asList(0, -3, -10, 9, 5));

    @Mock
    private Random rand;
    @InjectMocks
    private ConvertSortedArrayToBinarySearchTree108 underTest;

    @BeforeEach
    public void setUp() {
        solution = new ConvertSortedArrayToBinarySearchTree108();

        traversal = new BinaryTreePreorderTraversal144();
    }

    @Test
    void sortedArrayToBST1() {

        TreeNode result = solution.sortedArrayToBst1(nums);
        list = traversal.preorderTraversal1(result);

        Assertions.assertEquals(answer1, list);
    }

    @Test
    void sortedArrayToBST2() {

        TreeNode result = solution.sortedArrayToBst2(nums);
        list = traversal.preorderTraversal1(result);

        Assertions.assertEquals(answer2, list);
    }

    @Test
    void sortedArrayToBST3() {

        Mockito.when(rand.nextInt(2)).thenReturn(0);
        TreeNode result1 = underTest.sortedArrayToBst3(nums);
        list = traversal.preorderTraversal1(result1);
        Assertions.assertEquals(answer1, list);

        Mockito.when(rand.nextInt(2)).thenReturn(1);
        TreeNode result2 = underTest.sortedArrayToBst3(nums);
        list = traversal.preorderTraversal1(result2);
        Assertions.assertEquals(answer2, list);
    }

}