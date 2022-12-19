package pers.ricardolp.leetcode.easy;

/**
 * leetcode_155 : Min Stack.
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * <p>
 * Implement the MinStack class:
 *
 * <pre>
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * </pre>
 *
 * Constraints:
 * <p>
 * -2<sup>31</sup> <= val <= 2<sup>31</sup>-1 <br>
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks. <br>
 * At most 3 * 10<sup>4</sup> calls will be made to push, pop, top, and getMin.
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class MinStackB155 {

    /** Top element of the stack. */
    private ListNode top;

    /**
     * Add the element to the stack.
     *
     * @param val the element.
     */
    public void push(int val) {
        if (top == null) {
            top = new ListNode(val, val);
        } else {
            top = new ListNode(val, Math.min(val, top.min), top);
        }
    }

    /**
     * Pop the top element of the stack.
     */
    public void pop() {
        top = top.next;
    }

    /**
     * View the top element of the stack.
     *
     * @return the top element of the stack.
     */
    public int top() {
        return top.val;
    }

    /**
     * Get the smallest element in the stack.
     *
     * @return the smallest element in the stack.
     */
    public int getMin() {
        return top.min;
    }

    /**
     * linked list node.
     */
    private static class ListNode {

        /** Current node value. */
        int val;
        /** The minimum value in the stack. */
        int min;
        /** The next node in the stack. */
        ListNode next;

        private ListNode(int val, int min) {
            this(val, min, null);
        }

        private ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

        @Override
        public String toString() {
            return "val=" + val + ", min=" + min;
        }
    }

}
