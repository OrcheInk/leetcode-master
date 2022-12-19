package pers.ricardolp.leetcode.easy;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_21 : Merge Two Sorted Lists.
 * <p>
 * Merge two sorted linked lists and return it as a sorted list.
 * <p>
 * The list should be made by splicing together the nodes of the first two
 * lists.
 *
 * <pre>
 * Example 1:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: l1 = [], l2 = []
 * Output: []
 *
 * Example 3:
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50]. <br>
 * -100 {@code <=} Node.val {@code <= 100} <br>
 * Both {@code l1} and {@code l2} are sorted in non-decreasing order.
 *
 * @author RicardoLP
 * @since 2021/10/31
 */
public class MergeTwoSortedLists21 {

    /**
     * Solution1.
     * <p>
     * Set up a sentinel node {@code prehead}, if the value of the current node of
     * {@code l1} is less than or equal to {@code l2}.
     * <p>
     * We will connect the current node of {@code l1} to the back of the
     * {@code prev} node and move the {@code l1} pointer one bit backward.
     * <p>
     * Otherwise, we do the same for {@code l2}.
     *
     * @param l1 the linked list to be merged.
     * @param l2 the linked list to be merged.
     * @return the merged linked list.
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {

        // Sentinel node.
        ListNode prehead = new ListNode(0);
        ListNode prev = prehead;

        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }

        /*
         * After merging, at most one of l1 and l2 has not been merged,
         * we can directly point the end of the linked list to the unmerged linked list.
         */
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    /**
     * Solution2.
     * <p>
     * Perform the {@code mergeTwoLists2} operation on the node with the smaller
     * value in the head of the two linked lists and the remaining elements, then
     * merge the results.
     *
     * @param l1 the linked list that needs to be merged.
     * @param l2 the linked list that needs to be merged.
     * @return the merged linked list.
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode result = l2;

        if (l1 != null) {
            if (l2 == null) {
                result = l1;
            } else if (l1.val < l2.val) {
                l1.next = mergeTwoLists2(l1.next, l2);
                result = l1;
            } else {
                l2.next = mergeTwoLists2(l1, l2.next);
            }
        }

        return result;
    }

}
