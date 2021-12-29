package pers.ricardolp.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode_119 : Pascal's Triangle II.
 * <p>
 * Given an integer {@code rowIndex}, return the rowIndexth (0-indexed) row of
 * the Pascal's triangle.
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it as shown:
 *
 * <pre>
 * Example 1:
 * Input: rowIndex = 3
 * Output: [1,3,3,1]
 *
 * Example 2:
 * Input: rowIndex = 0
 * Output: [1]
 *
 * Example 3:
 * Input: rowIndex = 1
 * Output: [1,1]
 * </pre>
 *
 * Constraints:
 * <p>
 * 0 {@code <=} rowIndex {@code <=} 33
 * <p>
 * <b>Follow up:</b> Could you optimize your algorithm to use only O(rowIndex)
 * extra space?
 *
 * @author RicardoLP
 * @since 2021/12/20
 */
public class PascalsTriangle119 {

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
     * @param rowIndex the index of the line.
     * @return The result of {@code rowIndex} line.
     */
    public List<Integer> getRow1(int rowIndex) {

        // Traverse each list in lists.
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i <= rowIndex; ++i) {

            // Traverse every digit in the current list.
            List<Integer> list = new ArrayList<>();

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
        return lists.get(rowIndex);
    }

}
