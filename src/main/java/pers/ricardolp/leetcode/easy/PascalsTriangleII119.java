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
public class PascalsTriangleII119 {

    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> C = new ArrayList<>();

        for (int i = 0; i <= rowIndex; ++i) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; ++j) {

                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(C.get(i - 1).get(j - 1) + C.get(i - 1).get(j));
                }

            }
            C.add(row);
        }
        return C.get(rowIndex);
    }
}
