package pers.ricardolp.leetcode.easy;

import java.util.HashSet;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_141 : Linked List Cycle.
 * <p>
 * Given head, the {@code head} of a linked list, determine if the linked list
 * has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can
 * be reached again by continuously following the next pointer.
 * <p>
 * Internally, pos is used to denote the index of the node that tail's next
 * pointer is connected to. Note that pos is not passed as a parameter.
 * <p>
 * Return {@code true} if there is a cycle in the linked list. Otherwise, return
 * {@code false}.
 *
 * <pre>
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 10<sup>4</sup>]. <br>
 * -10<sup>5</sup> {@code <=} Node.val {@code <=} 10<sup>5</sup> <br>
 * pos is -1 or a valid index in the linked-list.
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class LinkedListCycle141 {

    /**
     * Solution1.
     * <p>
     * We can use a hash table to store all the nodes that have been visited. <br>
     * Every time we reach a node, if the node already exists in the hash table, it
     * means that the linked list is a circular linked list. <br>
     * Otherwise, the node is added to the hash table. <br>
     * Repeat this process until we traverse the entire linked list.
     *
     * @param head the head node of the linked list.
     * @return {@code true} if there is a ring in the linked list, {@code false}
     *         otherwise.
     */
    public boolean hasCycle1(ListNode head) {

        // Create a new HashSet to store the traversed nodes.
        HashSet<ListNode> set = new HashSet<>();

        while (head != null) {

            /*
             * The add() method returns a boolean
             * indicating whether the addition is successful.
             */
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Solution2.
     * <p>
     * Floyd Cycle Detection Algorithm.
     * <p>
     * When the fast and slow pointers meet, it indicates that there is a ring in
     * the linked list.
     * <p>
     * Looking for the ring entrance: <br>
     * When the fast and slow pointers meet, we reset the slow pointer to the origin
     * of the linked list, and set the fast and slow pointers to the same running
     * speed.<br>
     * The point where they meet again is the entrance of the ring.
     * <p>
     * Calculate the length of the loop: <br>
     * When the fast and slow pointers meet, we fix the fast pointer, let the slow
     * pointer continue to run, to count. <br>
     * When the fast and slow pointers meet again, it traverses the entire ring.
     *
     * @param head the head node of the linked list.
     * @return {@code true} if there is a ring in the linked list, {@code false}
     *         otherwise.
     */
    public boolean hasCycle2(ListNode head) {

        // If the linked list is empty or there is only one node, there is no ring.
        if (head == null || head.next == null) {
            return false;
        }

        // Establish fast and slow pointers.
        ListNode slow = head;
        ListNode fast = head.next;

        /*
         * When the fast and slow pointers meet and jump out of the loop,
         * it indicates that there is a ring in the linked list.
         */
        while (slow != fast) {

            // When the fast pointer reaches the end of the linked list, there is no ring.
            if (fast == null || fast.next == null) {
                return false;
            }

            // Move pointer.
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

}
