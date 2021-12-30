package pers.ricardolp.leetcode.easy.other;

import java.util.Objects;

/**
 * linked list node.
 *
 * @author RicardoLP
 * @since 2021/11/2
 */
public class ListNode {

    /** Current node value. */
    public int val;

    /** The next node. */
    public ListNode next;

    ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Output linked list.
     *
     * @return the contents of the list.
     */
    @Override
    public String toString() {
        return val + "," + next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListNode)) {
            return false;
        }
        ListNode listNode = (ListNode)o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

}
