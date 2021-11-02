package pers.ricardolp.leetcode.easy.other;

/**
 * linked list.
 *
 * @author RicardoLP
 * @since 2021/11/2
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + "," + next;
    }
}
