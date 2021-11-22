package pers.ricardolp.leetcode.easy;

/**
 * leetcode_7 : Reverse Integer.
 * <p>
 * Given a signed 32-bit integer {@code x}, return {@code x} with its digits
 * reversed.
 * <p>
 * If reversing {@code x} causes the value to go outside the signed 32-bit
 * integer range [-2<sup>31</sup>, 2<sup>31</sup> - 1], then return {@code 0}.
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
 * </pre>
 *
 * Constraints:
 * <p>
 * -2<sup>31</sup> {@code <=} x {@code <=} 2<sup>31</sup> - 1
 *
 * @author RicardoLP
 * @since 2021/9/5
 */
public class ReverseInteger7 {

    /**
     * Solution1.
     * <p>
     * Use mod operation to reverse the number.
     * <p>
     * Overflowing when condition
     * {@code rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10} is met.
     *
     * @param x the number to be reversed.
     * @return {@code 0} if overflow, the inverted number otherwise.
     */
    public int reverse1(int x) {
        int result = 1;

        int rev = 0;

        while (x != 0) {

            // Overflowing when condition is met.
            int base = 10;
            if (rev < Integer.MIN_VALUE / base || rev > Integer.MAX_VALUE / base) {
                result = 0;
                break;
            }

            // Break down the number.
            int digit = x % base;
            x /= base;
            rev = rev * base + digit;
        }
        if (result == 1) {
            result = rev;
        }
        return result;
    }

    /**
     * Solution2.
     * <p>
     * Use {@code String} to reverse the number.
     *
     * @param x the number to be reversed.
     * @return {@code 0} if overflow, the inverted number otherwise.
     */
    public int reverse2(int x) {
        int result;

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
            result = Integer.parseInt((new StringBuilder(str)).reverse().toString()) * flag;
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

}
