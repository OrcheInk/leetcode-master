package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_118 : Pascal's Triangle.
 * <p>
 * Given an integer {@code numRows}, return the first {@code numRows} of
 * Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 * <pre>
 * Example 1:
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * Example 2:
 * Input: numRows = 1
 * Output: [[1]]
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} numRows {@code <=} 30
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class PascalsTriangle118 {

    /**
     * Solution1.
     * <p>
     * Each number is equal to the sum of the left and right numbers in the previous
     * line, and this property can be used to write the entire Yang Hui triangle.
     * <blockquote>
     *
     * <pre>
     *      \mathcal{C}_{n}^{i}=\mathcal{C}_{n-1}^{i}+\mathcal{C}_{n-1}^{i-1}
     * </pre>
     *
     * </blockquote>
     *
     * @param numRows the number of lines.
     * @return The result of line {@code numRows}.
     */
    public List<List<Integer>> generate1(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();

        // Traverse each list in lists.
        for (int i = 0; i < numRows; i++) {

            List<Integer> list = new ArrayList<>();

            // Traverse every digit in the current list.
            for (int j = 0; j <= i; j++) {

                // Add the value to the current list.
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    /*
                     * Each number is equal to the sum of the left and right numbers
                     * in the previous list.
                     */
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }

            }

            lists.add(list);
        }
        return lists;
    }

}
