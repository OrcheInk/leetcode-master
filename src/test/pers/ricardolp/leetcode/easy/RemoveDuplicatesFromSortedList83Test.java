package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_83 : Remove Duplicates from Sorted List.
 *
 * @author RicardoLP
 * @since 2021/11/28
 */
class RemoveDuplicatesFromSortedList83Test {

    private RemoveDuplicatesFromSortedList83 solution;

    private ListNode head;

    private ListNode answer;

    @BeforeEach
    public void setUp() {

        head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode answerNode1 = new ListNode(2);
        ListNode answerNode2 = new ListNode(3);

        answer = new ListNode(1);
        answer.next = answerNode1;
        answerNode1.next = answerNode2;

        solution = new RemoveDuplicatesFromSortedList83();
    }

    @Test
    void deleteDuplicates1() {
        ListNode result = solution.deleteDuplicates1(head);
        Assertions.assertEquals(answer, result);

    }

    @Test
    void deleteDuplicates2() {
        ListNode result = solution.deleteDuplicates2(head);
        Assertions.assertEquals(answer, result);
    }

}