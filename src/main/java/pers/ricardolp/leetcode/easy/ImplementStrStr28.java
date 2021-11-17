package pers.ricardolp.leetcode.easy;

/**
 * leetcode_28 : Implement strStr.
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in the {@code haystack},
 * or {@code -1} if {@code needle} is not part of {@code haystack}.
 * <p>
 * <b>Clarification:</b>
 * <p>
 * What should we return when {@code needle} is an empty string? This is a great
 * question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return {@code 0} when {@code needle}
 * is an empty string. This is consistent to C's {@code strstr()} and Java's
 * {@code indexOf()}.
 *
 * <pre>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Example 3:
 * Input: haystack = "", needle = ""
 * Output: 0
 * </pre>
 *
 * Constraints:
 * <p>
 * 0 {@code <=} haystack.length, needle.length {@code <=} 5 * 10<sup>4</sup>
 * <br>
 * The {@code haystack} and {@code needle} consist of only lower-case English
 * characters.
 *
 * @author RicardoLP
 * @since 2021/11/3
 */
public class ImplementStrStr28 {

    /**
     * TODO Completion algorithm.
     * <p>
     * Solution1.
     *
     * @param haystack the specified string.
     * @param needle the pattern string.
     * @return the index of matching position.
     */
    public int strStr1(String haystack, String needle) {

        int i, j = 0;
        for (i = 0; i < haystack.length(); i++) {
            char ch1 = haystack.charAt(i);
            while (ch1 == needle.charAt(j) && j != needle.length() - 1) {
                j++;
            }
            i = haystack.indexOf(needle);
        }

        return i;
    }

}
