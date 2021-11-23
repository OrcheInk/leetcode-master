package pers.ricardolp.leetcode.easy;

/**
 * leetcode_70 : Climbing Stairs.
 * <p>
 * You are climbing a staircase. It takes {@code n} steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * <pre>
 * Example 1:
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * </pre>
 *
 * Constraints:
 * <p>
 * 1 {@code <=} n {@code <=} 45
 *
 * @author RicardoLP
 * @since 2021/11/10
 */
public class ClimbingStairs70 {

    /**
     * Solution1.
     * <p>
     * Recursion.
     *
     * @param n the number of steps to climb.
     * @return the number of methods that can be used.
     */
    public int climbStairs1(int n) {
        int result;
        int steps = 2;
        if (n <= steps) {
            result = n;
        } else {
            result = climbStairs1(n - 1) + climbStairs1(n - 2);
        }
        return result;
    }

    /**
     * Solution2.
     * <p>
     * Dynamic programming.
     *
     * @param n the number of steps to climb.
     * @return the number of methods that can be used.
     */
    public int climbStairs2(int n) {
        int result = 1;

        int f1;
        int f2 = 0;

        for (int i = 1; i <= n; i++) {
            f1 = f2;
            f2 = result;
            result = f1 + f2;
        }
        return result;
    }

    /**
     * Solution3.
     * <p>
     * matrix fast power
     *
     * @param n the number of steps to climb.
     * @return the number of methods that can be used.
     */
    public int climbStairs3(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    private int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    private int[][] multiply(int[][] a, int[][] b) {
        int constant = 2;
        int[][] c = new int[constant][constant];
        for (int i = 0; i < constant; i++) {
            for (int j = 0; j < constant; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * Solution4.
     * <p>
     * General term formula.
     *
     * @param n the number of steps to climb.
     * @return the number of methods that can be used.
     */
    public int climbStairs4(int n) {

        double sqrt5 = Math.sqrt(5);

        double fibonacci = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);

        return (int)Math.round(fibonacci / sqrt5);
    }

}
