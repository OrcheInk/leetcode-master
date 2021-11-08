package pers.ricardolp.leetcode.easy;

/**
 * leetcode_28 : Implement strStr.
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in the haystack, or -1 if
 * needle is not part of haystack.
 * <p>
 * <b>Clarification:</b>
 * <p>
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
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
 *
 * Constraints:
 *
 * 0 <= haystack.length, needle.length <= 5 * 10<sup>4</sup>
 * The haystack and needle consist of only lower-case English characters.
 * </pre>
 *
 * @author RicardoLP
 * @since 2021/11/3
 */
public class ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "helyllo", needle = "ll";
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr1(haystack, needle));
    }

    /**
     * TODO Completion algorithm.
     * <p>
     * Solution1.
     *
     * @param haystack the specified string.
     * @return the pattern string.
     */
    private int strStr1(String haystack, String needle) {

        int flag = -1;
        int i, j = 0;
        for (i = 0; i < haystack.length(); i++) {
            char ch1 = haystack.charAt(i);
            while (ch1 == needle.charAt(j) && j != needle.length() - 1) {
                System.out.println(i + " " + j);
                j++;
            }
            int i1 = haystack.indexOf(needle);
        }

        return i;
    }
}
