package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_141 : Linked List Cycle.
 *
 * @author RicardoLP
 * @since 2021/12/30
 */
class LinkedListCycle141Test {

    private LinkedListCycle141 solution;

    private ListNode head;

    @BeforeEach
    public void setUp() {

        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, null
        head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(10);
        ListNode node10 = new ListNode(11);
        ListNode node11 = new ListNode(12);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
        node11.next = node1;

        solution = new LinkedListCycle141();
    }

    @Test
    void hasCycle1() {
        boolean result = solution.hasCycle1(head);
        Assertions.assertTrue(result);
    }

    @Test
    void hasCycle2() {
        boolean result = solution.hasCycle2(head);
        Assertions.assertTrue(result);
    }

    @Test
    void hasCycle3() {
        boolean result = solution.hasCycle3(head);
        Assertions.assertTrue(result);
    }

}