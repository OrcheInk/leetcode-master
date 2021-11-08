package pers.ricardolp.leetcode.easy;

/**
 * leetcode_35 : Search Insert Position.
 * <p>
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * <pre>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * Example 4:
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 *
 * Example 5:
 * Input: nums = [1], target = 0
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10<sup>4</sup>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 * nums contains distinct values sorted in ascending order.
 * -10<sup>4</sup> <= target <= 10<sup>4</sup>
 * </pre>
 *
 * @author RicardoLP
 * @since 2021/11/4
 */
public class SearchInsertPosition {

    /**
     * Searches a range of the specified array of ints for the specified value using
     * the binary search algorithm.
     *
     * @param a the array to be searched.
     * @param fromIndex the index of the first element (inclusive) to be searched.
     * @param toIndex the index of the last element (exclusive) to be searched.
     * @param key the value to be searched for.
     * @return index of the search key, if it is contained in the array within the
     *         specified range; otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.
     *         The <i>insertion point</i> is defined as the point at which the key
     *         would be inserted into the array: the index of the first element in
     *         the range greater than the key, or <tt>toIndex</tt> if all elements
     *         in the range are less than the specified key. Note that this
     *         guarantees that the return value will be &gt;= 0 if and only if the
     *         key is found.
     * @throws IllegalArgumentException if {@code fromIndex > toIndex}
     * @throws ArrayIndexOutOfBoundsException if
     *             {@code fromIndex < 0 or toIndex > a.length}
     * @since 1.6
     */
    private static int binarySearch0(int[] a, int fromIndex, int toIndex, int key) {

        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {

            /*
             * The {@code >>>} treats the values as 32-bit unsigned int,
             * and the sum of two 31-bit signed ints cannot be larger than
             * a 32-bit unsigned int so there is no overflow for the purpose of this operation.
             * Note: if you used {@code >>} you could have a problem.
             */
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else
            // key found
            {
                return mid;
            }
        }
        // key not found.
        return -(low + 1);
    }

    /**
     * Solution1.
     * <p>
     * Use binary search.
     * <p>
     * Time complexity O(log n).
     *
     * @param nums the specified array.
     * @param target the target number.
     * @return the index of the target number.
     */
    private int searchInsert1(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {

            /*
             * If it is {@code (low + high) / 2}, overflow will occur when both
             * low and high are greater than half of the int range.
             */
            int mid = ((high - low) >> 1) + low;

            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

}
