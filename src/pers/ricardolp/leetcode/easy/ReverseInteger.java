package pers.ricardolp.leetcode.easy;

/**
 * leetcode_7 : Reverse Integer.
 * <p>
 * Given a signed 32-bit integer {@code x}, return {@code x} with its digits
 * reversed.
 * <p>
 * If reversing {@code x} causes the value to go outside the signed 32-bit
 * integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 *
 * <pre>
 * Example 1:
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 * Input: x = 120
 * Output: 21
 *
 * Example 4:
 * Input: x = 0
 * Output: 0
 *
 * Constraints:
 *
 * -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1
 * </pre>
 *
 * @author RicardoLP
 * @since 2021/9/5
 */
public class ReverseInteger {

    /**
     * Solution1.
     * <p>
     * Use mod operation to reverse the number.
     * <p>
     * Overflowing when condition
     * {@code rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10} is met.
     *
     * @param x the number to be reversed.
     * @return inverted number, or 0 when overflowing.
     */
    private int reverse1(int x) {

        int rev = 0;

        while (x != 0) {

            // Overflowing when condition is met.
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }

            // Break down the number.
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    /**
     * Solution2.
     * <p>
     * Use {@code String} to reverse the number.
     *
     * @param x the number to be reversed.
     * @return inverted number, or 0 when overflowing.
     */
    private int reverse2(int x) {

        String valueStr = String.valueOf(x);
        String str = valueStr;
        // Mark symbol.
        int flag = 1;

        if (x < 0) {
            flag = -1;
            // Truncate sign.
            str = valueStr.substring(1);
        }

        try {
            return Integer.parseInt((new StringBuilder(str)).reverse().toString()) * flag;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

}
