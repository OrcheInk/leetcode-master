package pers.ricardolp.leetcode.easy;

/**
 * leetcode_14 : Longest Common Prefix.
 * <p>
 * Write a function to find the longest common prefix string amongst an array of
 * strings. If there is no common prefix, return an empty string "".
 *
 * <pre>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix amongst the input strings.
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} strs.length {@code <=} 200 <br>
 * 0 {@code <=} strs[i].length {@code <=} 200 <br>
 * {@code strs[i]} consists of only lower-case English letters.
 *
 * @author RicardoLP
 * @since 2021/10/30
 */
public class LongestCommonPrefix14 {

    /**
     * Solution1.
     * <p>
     * Traverse each string in the string array in turn, and update the longest
     * common prefix for each traversed string.
     * <p>
     * After traversing all the strings, you can get the longest common prefix in
     * the string array.
     *
     * @param strs the string array to find the longest common prefix.
     * @return the longest common prefix of {@code strs}.
     */
    public String longestCommonPrefix1(String[] strs) {
        String result;

        if (strs.length == 1) {
            result = strs[0];
        } else {// The public prefix is shorter than all strings, choose any.
            String prefix = strs[0];
            for (String string : strs) {
                while (!string.startsWith(prefix)) {

                    // Make it shorter if the common prefix does not match.
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
            result = prefix;
        }

        return result;
    }

    /**
     * Solution2.
     * <p>
     * Traverse each column of all strings from front to back, compare whether the
     * characters on the same column are the same.
     * <p>
     * If they are the same, continue to compare the next column, if they are not
     * the same, the current column no longer belongs to the common prefix, and the
     * part before the current column is the longest Common prefix.
     *
     * @param strs the string array to find the longest common prefix.
     * @return the longest common prefix of {@code strs}.
     */
    public String longestCommonPrefix2(String[] strs) {
        String result = null;

        int length = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < length; i++) {

            char c = strs[0].charAt(i);

            for (int j = 1; j < count; j++) {

                // i == strs[j].length() explain that str[j] is one bit longer than str[0].
                if (i == strs[j].length() || strs[j].charAt(i) != c) {

                    // Make it shorter if the common prefix does not match.
                    result = strs[0].substring(0, i);
                    break;
                }
            }
            if (result != null) {
                break;
            }
        }
        if (result == null) {
            result = strs[0];
        }
        return result;
    }

}
