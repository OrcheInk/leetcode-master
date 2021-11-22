package pers.ricardolp.leetcode.easy.other;

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

}
