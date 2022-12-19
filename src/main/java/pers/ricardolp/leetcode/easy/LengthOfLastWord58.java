package pers.ricardolp.leetcode.easy;

/**
 * leetcode_58 : Length of Last Word.
 * <p>
 * Given a string {@code s} consisting of some words separated by some number of
 * spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 *
 * <pre>
 * Example 1:
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 *
 * Example 2:
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 *
 * Example 3:
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} s.length {@code <=} 10<sup>4</sup> <br>
 * {@code s} consists of only English letters and spaces ' '. <br>
 * There will be at least one word in {@code s}.
 *
 * @author RicardoLP
 * @since 2021/11/6
 */
public class LengthOfLastWord58 {

    /**
     * Solution1.
     *
     * @param s the string for which the length of the last word needs to be
     *            calculated.
     * @return the length of the last word in {@code s}.
     */
    public int lengthOfLastWord1(String s) {

        int length = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                break;
            }

        }
        return length;
    }

}
