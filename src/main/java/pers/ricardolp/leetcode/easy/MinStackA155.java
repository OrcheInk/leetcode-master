package pers.ricardolp.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

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
public class MinStackA155 {

    /** Stack. */
    Deque<Integer> stk;

    /** Storage the smallest value in the stack. */
    Deque<Integer> minStk;

    public MinStackA155() {

        stk = new LinkedList<>();
        minStk = new LinkedList<>();

        minStk.push(Integer.MAX_VALUE);
    }

    /**
     * Add the element to the stack.
     *
     * @param val the element.
     */
    public void push(int val) {
        stk.push(val);
        // noinspection ConstantConditions
        minStk.push(Math.min(minStk.peek(), val));
    }

    /**
     * Pop the top element of the stack.
     */
    public void pop() {
        stk.pop();
        minStk.pop();
    }

    /**
     * View the top element of the stack.
     *
     * @return the top element of the stack.
     */
    public int top() {
        // noinspection ConstantConditions
        return stk.peek();
    }

    /**
     * Get the smallest element in the stack.
     *
     * @return the smallest element in the stack.
     */
    public int getMin() {
        // noinspection ConstantConditions
        return minStk.peek();
    }

}
