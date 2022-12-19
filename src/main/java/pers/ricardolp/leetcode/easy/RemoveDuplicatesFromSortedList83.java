package pers.ricardolp.leetcode.easy;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_83 : Remove Duplicates from Sorted List.
 * <p>
 * Given the head of a sorted linked list, delete all duplicates such that each
 * element appears only once. Return the linked list sorted as well.
 *
 * <pre>
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 300]. <br>
 * -100 {@code <=} Node.val {@code <=} 100 <br>
 * The list is guaranteed to be sorted in ascending order.
 *
 * @author RicardoLP
 * @since 2021/11/11
 */
public class RemoveDuplicatesFromSortedList83 {

    /**
     * Solution1.
     * <p>
     * Because the position of repeated elements in the linked list is continuous,
     * we only need to traverse the linked list once to delete the repeated
     * elements.
     *
     * @param head the {@code head} node of the linked list.
     * @return the linked list after deleting duplicate nodes.
     */
    public ListNode deleteDuplicates1(ListNode head) {

        if (head != null) {

            ListNode cur = head;

            while (cur.next != null) {

                if (cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }

            }
        }
        return head;
    }

    /**
     * Solution2.
     * <p>
     * Recursion.
     * <p>
     * Because the position of repeated elements in the linked list is continuous,
     * we only need to traverse the linked list once to delete the repeated
     * elements.
     *
     * @param head the {@code head} node of the linked list.
     * @return the linked list after deleting duplicate nodes.
     */
    public ListNode deleteDuplicates2(ListNode head) {

        ListNode result;

        if (head != null && head.next != null) {

            head.next = deleteDuplicates2(head.next);

            if (head.val == head.next.val) {
                head = head.next;
            }
        }
        result = head;
        return result;
    }

}
