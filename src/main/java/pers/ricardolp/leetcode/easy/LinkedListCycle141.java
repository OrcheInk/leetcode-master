package pers.ricardolp.leetcode.easy;

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
    public boolean hasCycle(ListNode head) {
        return false;
    }
}
