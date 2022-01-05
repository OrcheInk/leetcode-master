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
     * means that the linked list is a circular-linked list. <br>
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

        // The length of the ring.
        int length = length(slow, fast);

        return true;
    }

    /**
     * Solution3.
     * <p>
     * Brent Cycle Detection Algorithm.
     * <p>
     * The fast and slow pointers point to the head node at the same time. <br>
     * The running step of the fast pointer increases from 0, and the upper limit is
     * 2^{i}(i=0,1,2,...). <br>
     * When the running step of the fast pointer reaches the upper limit, return the
     * slow pointer to the fast pointer. <br>
     * Repeat the above steps, if the fast pointer catches up with the slow pointer,
     * it means there is a ring in the linked list, otherwise there is no ring. <br>
     * <p>
     * The algorithm cannot find the entry node of the ring.
     * <p>
     * Calculate the length of the loop: <br>
     * When the step reaches the upper limit, the fast and slow pointers meet, we
     * fix the fast pointer, let the slow pointer run in steps of 1, to count. <br>
     * When the fast and slow pointers meet again, it traverses the entire ring.
     *
     * @param head the head node of the linked list.
     * @return {@code true} if there is a ring in the linked list, {@code false}
     *         otherwise.
     */
    public boolean hasCycle3(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        // Set running step.
        int steps = 0;
        // Set the upper limit of running step.
        int limit = 2;

        while (fast != null) {

            // Traversing the linked list, step is 1.
            fast = fast.next;

            // If the fast and slow pointers meet, there is a ring in the linked list.
            if (fast == slow) {
                return true;
            }

            // If the fast and slow pointers do not meet, increase the step.
            steps++;
            /*
             * When the step reaches the limit,
             * and the fast and slow pointers do not meet.
             */
            if (steps == limit) {

                // Let the fast and slow pointers coincide.
                slow = fast;

                // The length of the ring.
                int length = length(slow, fast);

                // Reset running step.
                steps = 0;

                // The upper limit of running step is 2^{i}(i=0,1,2,...).
                limit *= 2;
            }
        }
        return false;
    }

    /**
     * Calculate the length of the ring in the linked list.
     *
     * @param slow slow pointer.
     * @param fast fast pointer.
     * @return the length of the ring.
     */
    private int length(ListNode slow, ListNode fast) {

        fast = fast.next;
        int count = 1;

        try {
            while (slow != fast) {
                count++;
                fast = fast.next;
            }
        } catch (NullPointerException e) {
            return 0;
        }

        return count;
    }

}
