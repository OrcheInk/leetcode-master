package pers.ricardolp.leetcode.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetcode_20 : Valid Parentheses.
 * <p>
 * Given a string {@code s} containing just the characters '(', ')', '{', '}',
 * '[' and ']', determine if the input string is valid.
 *
 * <pre>
 * An input string is valid if:
 *
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Example 4:
 * Input: s = "([)]"
 * Output: false
 *
 * Example 5:
 * Input: s = "{[]}"
 * Output: true
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} s.length {@code <=} 10<sup>4</sup> <br>
 * {@code s} consists of parentheses only '()[]{}'.
 *
 * @author RicardoLP
 * @since 2021/10/30
 */
public class ValidParentheses20 {

    /**
     * Solution1.
     * <p>
     * Judging the validity of parentheses can be solved by using the data structure
     * "stack".
     * <p>
     * After the traversal is over, if there is no left parenthesis in the stack, it
     * means that we close all the left parentheses in the string {@code s} and
     * return {@code true}, otherwise return {@code false}.
     *
     * @param s the string to be verified.
     * @return {@code true} if the string {@code s} is legal, {@code false}
     *         otherwise.
     */
    public boolean isValid1(String s) {
        boolean result = true;

        int length = s.length();
        // If the string length is odd, return false.
        int half = 2;
        if (length % half != 0) {
            result = false;
        } else {

            /*
             * In order to quickly determine the type of parentheses,
             * we can use a hash table to store each type of parentheses.
             */
            int initialCapacity = 3;
            HashMap<Character, Character> hash = new HashMap<>(initialCapacity);
            hash.put(')', '(');
            hash.put('}', '{');
            hash.put(']', '[');
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < length; i++) {

                char ch = s.charAt(i);

                if (hash.containsKey(ch)) {
                    // Determine whether the current bracket matches the top of the stack.
                    if (stack.isEmpty() || !stack.peek().equals(hash.get(ch))) {
                        result = false;
                        break;
                    } else {
                        stack.pop();
                    }

                } else {
                    stack.push(ch);
                }
            }
            if (result) {
                result = stack.isEmpty();
            }
        }

        return result;
    }

    /**
     * Solution2.
     * <p>
     * Use arrays to simulate stack operations.
     *
     * @param s the string to be verified.
     * @return {@code true} if the string {@code s} is legal, {@code false}
     *         otherwise.
     */
    public boolean isValid2(String s) {
        boolean result = true;

        // If the string length is odd, return false.
        int half = 2;
        if (s.length() % half != 0) {
            result = false;
        } else {
            int count = 1;
            char[] array = new char[s.length() + 1];
            for (int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                if (c == '(' || c == '[' || c == '{') {
                    // Push.
                    array[count++] = c;
                } else {
                    // Pop.
                    count--;
                    if (array[count] != '(' && c == ')') {
                        result = false;
                        break;
                    }
                    if (array[count] != '[' && c == ']') {
                        result = false;
                        break;
                    }
                    if (array[count] != '{' && c == '}') {
                        result = false;
                        break;
                    }
                }
            }
            if (result) {
                result = count == 1;
            }
        }

        return result;
    }

    /**
     * Solution3!
     * <p>
     * Use ASCII as the judgment condition.
     * <p>
     * Use arrays to simulate stack operations.
     *
     * <pre>
     *      '(' :   40
     *      ')' :   41
     *      '[' :   91
     *      ']' :   93
     *      '{' :   123
     *      '}' :   125
     * </pre>
     *
     * @param s the string to be verified.
     * @return {@code true} if the string {@code s} is legal, {@code false}
     *         otherwise.
     */
    public boolean isValid3(String s) {

        char[] array = s.toCharArray();
        // Place unpaired parentheses.
        char[] temp = new char[array.length];
        int count = 0;

        for (char aChar : array) {
            temp[count] = aChar;

            /*
             * If there is a difference of 1 or 2 between the ASCII codes of adjacent
             * brackets, the brackets match.
             */
            if (count != 0) {
                int condition = temp[count] - temp[count - 1];
                if ((condition == 1 || condition == 2)) {
                    count--;
                }
            } else {
                count++;
            }
        }
        return count == 0;
    }

    /**
     * Solution4.
     * <p>
     * Use {@code replace()} to eliminate a pair of parentheses in a loop. After the
     * loop, if the string is empty, it is a legal string.
     *
     * @param s the string to be verified.
     * @return {@code true} if the string {@code s} is legal, {@code false}
     *         otherwise.
     */
    public boolean isValid4(String s) {
        boolean result = false;

        // If the string length is odd, return false.
        int half = 2;
        if (s.length() % half == 0) {
            int length = s.length() / 2;
            for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
            }
            result = s.length() == 0;
        }

        return result;
    }

}
