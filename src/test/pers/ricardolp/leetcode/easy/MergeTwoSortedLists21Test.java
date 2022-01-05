package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_21 : Merge Two Sorted Lists.
 *
 * @author RicardoLP
 * @since 2021/11/29
 */
class MergeTwoSortedLists21Test {

    private MergeTwoSortedLists21 solution;

    private ListNode l1;
    private ListNode l2;

    private String answer = "1, 1, 2, 3, 4, 4, null";

    @BeforeEach
    public void setUp() {

        l1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);

        l1.next = node1;
        node1.next = node2;

        l2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        l2.next = node3;
        node3.next = node4;

        solution = new MergeTwoSortedLists21();
    }

    @Test
    void mergeTwoLists1() {
        ListNode result = solution.mergeTwoLists1(l1, l2);
        Assertions.assertEquals(answer, result.toString());
    }

    @Test
    void mergeTwoLists2() {
        ListNode result = solution.mergeTwoLists2(l1, l2);
        Assertions.assertEquals(answer, result.toString());
    }

}
