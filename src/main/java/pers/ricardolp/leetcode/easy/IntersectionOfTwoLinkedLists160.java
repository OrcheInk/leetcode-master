package pers.ricardolp.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import pers.ricardolp.leetcode.easy.other.ListNode;

/**
 * leetcode_160 : Intersection of Two Linked Lists.
 * <p>
 * Given the heads of two singly linked-lists {@code headA} and {@code headB},
 * return the node at which the two lists intersect. If the two linked lists
 * have no intersection at all, return null.
 * <p>
 * The test cases are generated such that there are no cycles anywhere in the
 * entire linked structure.
 * <p>
 * Note that the linked lists must retain their original structure after the
 * function returns.
 *
 * <pre>
 * <b>Custom Judge:</b>
 *
 * The inputs to the judge are given as follows (your program is not given these inputs):
 *
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
 *
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Example 2:
 * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Intersected at '2'
 * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * Example 3:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: No intersection
 * Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes of listA is in the m. <br>
 * The number of nodes of listB is in the n. <br>
 * 1 <= m, n <= 3 * 10<sup>4</sup> <br>
 * 1 <= Node.val <= 10<sup>5</sup> <br>
 * 0 <= skipA < m <br>
 * 0 <= skipB < n <br>
 * intersectVal is 0 if listA and listB do not intersect. <br>
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 * <p>
 * <b>Follow up:</b> Could you write a solution that runs in O(m + n) time and
 * use only O(1) memory?
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class IntersectionOfTwoLinkedLists160 {

    /**
     * Solution1.
     * <p>
     * Use the hash table to store the visited nodes, if there are duplicates, it
     * means that the two linked lists have intersections.
     *
     * @param headA the head node of the first linked list.
     * @param headB the head node of the second linked list.
     * @return the intersection of two linked lists.
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {

        // If there is an empty-linked list, there is no intersection.
        if (headA == null || headB == null) {
            return null;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode cur = headA;

        // Store the node of the A-linked list.
        while (cur != null) {
            visited.add(cur);
            cur = cur.next;
        }

        cur = headB;
        // Check whether there are nodes of the B-linked list in the hash table.
        while (cur != null) {
            if (visited.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;

    }

    /**
     * Solution2.
     * <p>
     * Double pointer method.
     * <p>
     * When the linked lists {@code headA} and {@code headB} are not empty, two
     * pointers {@code pointerA} and {@code pointerB} are created, which initially
     * point to the head nodes {@code headA} and {@code headB} of the two linked
     * lists respectively, and then the two pointers traverse each node of the two
     * linked lists in turn.
     * <p>
     * Each operation needs to update the pointers {@code pointerA} and
     * {@code pointerB} at the same time.
     * <p>
     * If the pointer {@code pointerA} is not empty, move the pointer
     * {@code pointerA} to the next node. <br>
     * if the pointer {@code pointerB} is not empty, move the pointer
     * {@code pointerB} to the next node.
     * <p>
     * If the pointer {@code pointerA} is empty, move the pointer {@code pointerA}
     * to the head node of the linked list {@code pointerB}. <br>
     * if the pointer {@code pointerB} is empty, move the pointer {@code pointerB}
     * Go to the head node of the linked list {@code headA}.
     * <p>
     * When the pointers {@code pointerA} and {@code pointerB} point to the same
     * node or are empty, return the node they point to or {@code null}.
     *
     * @param headA the head node of the first linked list.
     * @param headB the head node of the second linked list.
     * @return the intersection of two linked lists.
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        // If there is an empty-linked list, there is no intersection.
        if (headA == null || headB == null) {
            return null;
        }

        // Initialize pointer.
        ListNode pointerA = headA, pointerB = headB;

        while (pointerA != pointerB) {
            // If pointerA is equal to null, point the next node to headB.
            pointerA = pointerA == null ? headB : pointerA.next;
            // If pointerB is equal to null, point the next node to headA.
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }

    /**
     * Solution3.
     * <p>
     * Construct a circular linked list, the entry of the linked list is the
     * intersection point.
     *
     * @param headA the head node of the first linked list.
     * @param headB the head node of the second linked list.
     * @return the intersection of two linked lists.
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        // If there is an empty-linked list, there is no intersection.
        if (headA == null || headB == null) {
            return null;
        }

        ListNode last = headB;

        // Find the end of the linked list.
        while (last.next != null) {
            last = last.next;
        }
        // Connect the B-linked list end to start to form a circular linked list.
        last.next = headB;

        // Initialize fast and slow pointers.
        ListNode fast = headA;
        ListNode slow = headA;

        // Find the entrance to the circular linked list.
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Fast and slow pointers meet.
            if (slow == fast) {

                // Reset the slow pointer to the origin of the linked list.
                slow = headA;

                /*
                 * When jumping out of the loop, the fast and slow pointers meet again,
                 * which is the entry of the linked list.
                 */
                while (slow != fast) {
                    // Set the fast and slow pointers to the same running speed.
                    slow = slow.next;
                    fast = fast.next;
                }

                // There is intersection in the linked list, break the end.
                last.next = null;

                return fast;
            }
        }
        // There is no intersection in the linked list, break the end.
        last.next = null;
        return null;
    }

}
