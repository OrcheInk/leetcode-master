package pers.ricardolp.leetcode.easy;

/**
 * leetcode_66 : Plus One.
 * <p>
 * You are given a large integer represented as an integer array digits, where
 * each {@code digits[i]} is the ith digit of the integer.
 * <p>
 * The digits are ordered from most significant to the least significant in
 * left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 *
 * <pre>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 * Input: digits = [0]
 * Output: [1]
 * Explanation: The array represents the integer 0.
 * Incrementing by one gives 0 + 1 = 1.
 * Thus, the result should be [1].
 *
 * Example 4:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} digits.length {@code <=} 100 <br>
 * 0 {@code <=} digits[i] {@code <=} 9 <br>
 * digits does not contain any leading 0's.
 *
 * @author RicardoLP
 * @since 2021/11/7
 */
public class PlusOne66 {

    /**
     * Solution1.
     *
     * @param digits the integer array to be calculated .
     * @return the integer array obtained by adding one after the original array is
     *         converted to an integer.
     */
    public int[] plusOne1(int[] digits) {
        int[] result = null;

        for (int i = digits.length - 1; i >= 0; i--) {

            int needToCarry = 9;
            if (digits[i] != needToCarry) {
                digits[i]++;
                result = digits;
                break;
            }

            digits[i] = 0;
        }
        // Jump out of the loop, indicating that all numbers are 9.
        if (result == null) {
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            result = temp;
        }

        return result;
    }

}
