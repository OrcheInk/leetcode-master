package pers.ricardolp.leetcode.easy;

import java.util.HashMap;

/**
 * leetcode_13 : Roman to Integer.
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
 * and M.
 *
 * <pre>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * </pre>
 *
 * For example, 2 is written as II in Roman numeral, just two ones' added
 * together. 12 is written as XII, which is simply X + II. The number 27 is
 * written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is
 * written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 *
 * <pre>
 * There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 *
 * Example 2:
 * Input: s = "IV"
 * Output: 4
 *
 * Example 3:
 * Input: s = "IX"
 * Output: 9
 *
 * Example 4:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 5:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} s.length {@code <=} 15 <br>
 * {@code s} contains only the characters ('I', 'V', 'X', 'L', 'C','D', 'M').
 * <br>
 * It is guaranteed that {@code s} is a valid roman numeral in the range [1,
 * 3999].
 *
 * @author RicardoLP
 * @since 2021/10/29
 */
public class RomanToInteger13 {

    /**
     * Solution1.
     * <p>
     * Use switch to determine the value corresponding to the Roman numeral
     * character.
     *
     * @param s the Roman numeral string to be recognized.
     * @return the integer corresponding to {@code s}.
     */
    public int romanToInt1(String s) {

        int len = s.length();
        int num = 0;

        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    num++;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s.charAt(i));
            }
        }

        for (int i = 0; i < len - 1; i++) {

            boolean condition1 = s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X');
            if (condition1) {
                num -= 2;
            } else {
                boolean condition2 = s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C');
                if (condition2) {
                    num -= 20;
                } else {
                    boolean condition3 = s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M');
                    if (condition3) {
                        num -= 200;
                    }
                }
            }

        }
        return num;
    }

    /**
     * Solution2.
     * <p>
     * Use HashMap to type in the value corresponding to the Roman numeral
     * character.
     *
     * @param s the Roman numeral string to be recognized.
     * @return the integer corresponding to {@code s}.
     */
    public int romanToInt2(String s) {

        int sum = 0;
        HashMap<Character, Integer> map = new HashMap<>(7);

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            if (i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
                sum -= map.get(chars[i]);
            } else {
                sum += map.get(chars[i]);
            }

        }
        return sum;
    }

    /**
     * Solution3.
     * <p>
     * Use {@code replace} to replace special cases, and then perform calculations.
     *
     * @param s the Roman numeral string to be recognized.
     * @return the integer corresponding to {@code s}.
     */
    public int romanToInt3(String s) {

        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += getValue(s.charAt(i));
        }
        return res;
    }

    /**
     * Get the value represented by the specified Roman numeral.
     *
     * @param c the Roman numeral character.
     * @return the value corresponding to {@code c}.
     */
    private int getValue(char c) {
        int result;

        switch (c) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
                break;
            case 'a':
                result = 4;
                break;
            case 'b':
                result = 9;
                break;
            case 'c':
                result = 40;
                break;
            case 'd':
                result = 90;
                break;
            case 'e':
                result = 400;
                break;
            case 'f':
                result = 900;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }

        return result;
    }

}
