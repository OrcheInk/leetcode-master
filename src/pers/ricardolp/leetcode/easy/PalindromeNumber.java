package pers.ricardolp.leetcode.easy;

/**
 * leetcode_9 : Palindrome Number.
 * <p>
 * Given an integer x, return true if x is palindrome integer.
 *
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
 * -2<sup>31</sup>&lt;= x &lt;= 2<sup>31</sup> - 1
 *
 * @author RicardoLP
 * @since 2021/10/21
 */
public class PalindromeNumber {

    /**
     * Solution1.
     * <p>
     * Use mod operation to reverse numbers and compare before and after, when the
     * original number is less than or equal to the inverted number, it means that
     * we have processed half of the digits.
     *
     * @param x an integer.
     * @return true if x is palindrome integer.
     */
    public static boolean isPalindrome1(int x) {
        // Filter condition.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    /**
     * Solution2.
     * <p>
     * Use mod operation to reverse numbers and compare before and after.
     *
     * @param x an integer.
     * @return true if x is palindrome integer.
     */
    private static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int remainder, y = 0;
        int quotation = x;
        while (quotation != 0) {
            remainder = quotation % 10;
            y = y * 10 + remainder;
            quotation = quotation / 10;
        }
        return y == x;
    }

    /**
     * Solution3.
     * <p>
     * Convert the number into a string, and judge whether the characters before and
     * after are equal.
     *
     * @param x an integer.
     * @return true if x is palindrome integer.
     */
    private static boolean isPalindrome3(int x) {
        boolean flag = false;
        String str = Integer.toString(x);
        if (str.length() == 1) {
            return true;
        }
        for (int i = 0; i < str.length() / 2; i++) {
            flag = str.charAt(i) == str.charAt(str.length() - 1 - i);
            if (!flag) {
                return false;
            }
        }
        return flag;
    }

}
