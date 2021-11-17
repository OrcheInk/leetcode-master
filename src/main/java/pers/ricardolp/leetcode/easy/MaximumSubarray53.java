package pers.ricardolp.leetcode.easy;

/**
 * leetcode_53 : Maximum Subarray.
 * <p>
 * Given an integer array {@code nums}, find the contiguous subarray (containing
 * at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 *
 * <pre>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Example 2:
 * Input: nums = [1]
 * Output: 1
 *
 * Example 3:
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} nums.length {@code <=} 10<sup>5</sup> <br>
 * -10<sup>4</sup> {@code <=} nums[i] {@code <=} 10<sup>4</sup>
 * <p>
 * <b>Follow up:</b> If you have figured out the O(n) solution, try coding
 * another solution using the divide and conquer approach, which is more subtle.
 *
 * @author RicardoLP
 * @since 2021/11/5
 */
public class MaximumSubarray53 {

    /**
     * Solution1.
     * <p>
     * Dynamic programming.
     *
     * @param nums the array to calculate the largest sum of the contiguous
     *            subarray.
     * @return the largest sum of the contiguous subarray in {@code nums}.
     */
    public int maxSubArray1(int[] nums) {

        int pre = 0, result = nums[0];

        for (int num : nums) {

            // pre is the largest sum of the contiguous subarray.
            pre = Math.max(pre + num, num);

            // record the maximum value in pre.
            result = Math.max(result, pre);

        }
        return result;
    }

    /**
     * Solution2.
     * <p>
     * Greedy algorithm.
     *
     * @param nums the array to calculate the largest sum of the contiguous
     *            subarray.
     * @return the largest sum of the contiguous subarray in {@code nums}.
     */
    public int maxSubArray2(int[] nums) {

        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {

            // accumulate the value of num.
            sum += num;

            // record the maximum value in sum.
            result = Math.max(result, sum);

            /*
             * If the value of sum is less than 0,
             * discard the previous sequence and restart the calculation.
             */
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    /**
     * TODO Completion algorithm.
     * <p>
     * Solution3.
     * <p>
     * Divide-and-Conquer Algorithm.
     *
     * @param nums the array to calculate the largest sum of the contiguous
     *            subarray.
     * @return the largest sum of the contiguous subarray in {@code nums}.
     */
    public int maxSubArray3(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    private Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    static final class Status {
        private int lSum, rSum, mSum, iSum;

        private Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

}
