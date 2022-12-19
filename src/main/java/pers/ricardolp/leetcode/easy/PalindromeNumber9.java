package pers.ricardolp.leetcode.easy;

/**
 * leetcode_9 : Palindrome Number.
 * <p>
 * Given an integer {@code x}, return {{@code true} if {@code x} is palindrome
 * integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward. For
 * example, 121 is palindrome while 123 is not.
 *
 * <pre>
 * Example 1:
 * Input: x = 121
 * Output: true
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-.
 * Therefore, it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 *
 * Example 4:
 * Input: x = -101
 * Output: false
 * </pre>
 *
 * Constraints:
 * <p>
 * -2<sup>31</sup> {@code <=} x {@code <=} 2<sup>31</sup> - 1
 *
 * @author RicardoLP
 * @since 2021/10/21
 */
public class PalindromeNumber9 {

    /**
     * Solution1.
     * <p>
     * Use mod operation to reverse numbers and compare before and after, when the
     * original number is less than or equal to the inverted number, it means that
     * we have processed half of the digits.
     *
     * @param x the number to determine whether it is a palindrome.
     * @return {@code true} if {@code x} is palindrome integer,{@code false}
     *         otherwise.
     */
    public boolean isPalindrome1(int x) {
        boolean result = false;

        // Filter condition.
        int base = 10;
        boolean condition = x >= 0 && (x % base != 0 || x == 0);
        if (condition) {
            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * base + x % base;
                x /= base;
            }
            result = x == revertedNumber || x == revertedNumber / base;
        }

        return result;
    }

    /**
     * Solution2.
     * <p>
     * Use mod operation to reverse numbers and compare before and after.
     *
     * @param x the number to determine whether it is a palindrome.
     * @return {@code true} if {@code x} is palindrome integer,{@code false}
     *         otherwise.
     */
    public boolean isPalindrome2(int x) {
        boolean result = false;

        if (x >= 0) {
            int remainder, y = 0;
            int quotation = x;
            while (quotation != 0) {
                int base = 10;
                remainder = quotation % base;
                y = y * base + remainder;
                quotation = quotation / base;
            }
            result = y == x;
        }

        return result;
    }

    /**
     * Solution3.
     * <p>
     * Convert the number into a string, and judge whether the characters before and
     * after are equal.
     *
     * @param x the number to determine whether it is a palindrome.
     * @return {@code true} if {@code x} is palindrome integer,{@code false}
     *         otherwise.
     */
    public boolean isPalindrome3(int x) {
        boolean result = true;
        boolean finished = false;

        boolean flag = false;
        String str = Integer.toString(x);

        if (str.length() != 1) {
            int half = 2;
            for (int i = 0; i < str.length() / half; i++) {

                flag = str.charAt(i) == str.charAt(str.length() - 1 - i);

                if (!flag) {
                    result = false;
                    finished = true;
                    break;
                }
            }
            if (!finished) {
                result = flag;
            }
        }

        return result;
    }

}
