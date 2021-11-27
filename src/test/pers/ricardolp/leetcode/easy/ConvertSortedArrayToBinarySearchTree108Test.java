package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.util.StopWatch;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_108 : Convert Sorted Array to Binary Search Tree.
 *
 * @author RicardoLP
 * @since 2021/11/18
 */
class ConvertSortedArrayToBinarySearchTree108Test {

    private ConvertSortedArrayToBinarySearchTree108 solution;
    private BinaryTreeInorderTraversal94 traversal;
    private List<Integer> list;
    private int[] nums = {-10, -3, 0, 5, 9};

    @Mock
    private Random rand;
    @InjectMocks
    private ConvertSortedArrayToBinarySearchTree108 underTest;
    private long startTime;

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

        TreeNode result = solution.sortedArrayToBst1(nums);
        list = traversal.preOrderTraversal(result);

        Assertions.assertEquals(answer, list);
    }

    @Test
    void sortedArrayToBST2() {

        List<Integer> answer = new ArrayList<>(Arrays.asList(0, -3, -10, 9, 5));

        TreeNode result = solution.sortedArrayToBst2(nums);
        list = traversal.preOrderTraversal(result);

        Assertions.assertEquals(answer, list);
    }

    @Test
    void sortedArrayToBST3() {

        TreeNode result = solution.sortedArrayToBst3(nums);
        list = traversal.preOrderTraversal(result);
    }

    @Test
    void time() {
        StopWatchExpand.init();
        StopWatchExpand.start("1");
        solution.sortedArrayToBst1(nums);
        StopWatchExpand.stop();
        StopWatchExpand.start("2");
        solution.sortedArrayToBst2(nums);
        StopWatchExpand.stop();
        StopWatchExpand.start("3");
        solution.sortedArrayToBst3(nums);
        StopWatchExpand.stop();
        String print = StopWatchExpand.prettyPrint();
        System.out.println(print);
    }

    @Test
    void timeWatch() {
        StopWatch watch = new StopWatch();
        watch.start("1");
        solution.sortedArrayToBst1(nums);
        watch.stop();
        watch.start("2");
        solution.sortedArrayToBst2(nums);
        watch.stop();
        watch.start("3");
        solution.sortedArrayToBst3(nums);
        watch.stop();
        String print = watch.prettyPrint();
        System.out.println(print);
    }

}