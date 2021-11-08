package pers.ricardolp.leetcode.easy;

/**
 * leetcode_67 : Add Binary.
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * <pre>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 10<sup>4</sup>
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 * </pre>
 *
 * @author RicardoLP
 * @since 2021/11/8
 */
public class AddBinary {

    /**
     * Solution1.
     * <p>
     * Traverse from the lowest bit.
     * <p>
     * We use a variable {@code carry} to represent the carry of the previous
     * position, with an initial value of 0.
     * <p>
     * Remember the two digits aligned at the current position are {@code aInt} and
     * {@code bInt}, then the answer for each digit is
     * {@code (aInt + bInt + carry) % 2}, and the carry of the next digit is
     * {@code (aInt + bInt + carry) / 2}.
     *
     * @param a the specified binary string.
     * @param b the specified binary string.
     * @return the binary string after addition.
     */
    private String addBinary1(String a, String b) {

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        StringBuilder result = new StringBuilder();

        int i = aChars.length - 1, j = bChars.length - 1;

        // Carry from the previous position.
        int carry = 0;

        // Jump out of the loop when all conditions are not met.
        while (carry != 0 || j >= 0 || i >= 0) {

            /*
             * Add '0' to the shorter of the {@code a} and {@code b} until they are the same length.
             *
             * Because char[] returns char, so  {@code - '0'} converts it to an integer.
             */
            int aInt = i >= 0 ? aChars[i] - '0' : 0;
            int bInt = j >= 0 ? bChars[j] - '0' : 0;

            int temp = aInt + bInt + carry;

            // Calculate the carry of the current position.
            carry = temp / 2;

            // Keep the final result.
            result.append(temp % 2);

            i--;
            j--;
        }
        return result.reverse().toString();
    }
}
