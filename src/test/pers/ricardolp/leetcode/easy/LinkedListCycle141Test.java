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

        head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

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

}