package pers.ricardolp.leetcode.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_160 : Intersection of Two Linked Lists.
 *
 * @author RicardoLP
 * @since 2022/1/4
 */
class IntersectionOfTwoLinkedLists160Test {

    private IntersectionOfTwoLinkedLists160 solution;

    private ListNode headA;
    private ListNode headB;

    private int answer = 8;

    @BeforeEach
    public void setUp() {

        // 4, 1, 8, 4, 5, null
        headA = new ListNode(4);
        ListNode node1 = new ListNode(1);

        // 5, 6, 1, 8, 4, 5, null
        headB = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(1);

        // Intersection.
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        headA.next = node1;
        node1.next = node4;

        headB.next = node2;
        node2.next = node3;
        node3.next = node4;

        node4.next = node5;
        node5.next = node6;

        solution = new IntersectionOfTwoLinkedLists160();
    }

    @Test
    void getIntersectionNode1() {
        ListNode result = solution.getIntersectionNode1(headA, headB);
        Assertions.assertEquals(answer, result.val);
    }

    @Test
    void getIntersectionNode2() {
        ListNode result = solution.getIntersectionNode2(headA, headB);
        Assertions.assertEquals(answer, result.val);
    }

    @Test
    void getIntersectionNode3() {
        ListNode result = solution.getIntersectionNode3(headA, headB);
        Assertions.assertEquals(answer, result.val);
    }

}