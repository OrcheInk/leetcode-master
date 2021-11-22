package pers.ricardolp.leetcode.easy;

/**
 * leetcode_69 : Sqrt(x).
 * <p>
 * Given a non-negative integer {@code x}, compute and return the square root of
 * {@code x}.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * <p>
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as {@code pow(x, 0.5)} or {@code x ** 0.5}.
 *
 * <pre>
 * Example 1:
 * Input: x = 4
 * Output: 2
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * </pre>
 *
 * Constraints:
 * <p>
 * 0 {@code <=} x {@code <=} 2<sup>31</sup> - 1
 *
 * @author RicardoLP
 * @since 2021/11/9
 */
public class SqrtX69 {

    /**
     * Solution1.
     * <p>
     * Brutal-Force.
     *
     * @param x the value for which the square root needs to be calculated.
     * @return the square root of {@code x}.
     */
    public int mySqrt1(int x) {

        int result = 0;
        int product = 0;

        while (product <= x && product >= 0) {
            result++;
            product = result * result;
        }

        return --result;
    }

    /**
     * Solution2.
     * <p>
     * Replace the square root function with exponential function <b>exp</b> and
     * logarithmic function <b>ln</b>. <blockquote>
     *
     * <pre>
     *      \sqrt{x}=x^\frac{1}{2}=\left(e^{\ln x}\right)^\frac{1}{2}=e^{\frac{1}{2} \lnx}
     * </pre>
     *
     * </blockquote>
     * <p>
     * Because the computer cannot store the exact value of a floating-point number.
     * <br>
     * The parameters and return values of exponential function and logarithmic
     * function are all floating-point numbers, so there will be errors in the
     * operation process. <br>
     * So after getting the integer part {@code ans} of the result, we should find
     * out which of {@code ans} and {@code ans + 1} is the real answer.
     *
     * @param x the value for which the square root needs to be calculated.
     * @return the square root of {@code x}.
     */
    public int mySqrt2(int x) {

        int result = 0;
        if (x != 0) {
            double half = 0.5;
            int ans = (int)Math.exp(half * Math.log(x));
            // Judging the final result.
            result = (long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
        }

        return result;
    }

    /**
     * Solution3.
     * <p>
     * Binary-search.
     *
     * @param x the value for which the square root needs to be calculated.
     * @return the square root of {@code x}.
     */
    public int mySqrt3(int x) {

        int low = 0, high = x, result = 0;

        while (low <= high) {

            // Calculate the median dichotomy.
            int mid = low + ((high - low) >> 1);

            // Convert the result to long type to prevent overflow.
            if ((long)mid * mid <= x) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    /**
     * Solution4.
     * <p>
     * Newton-Raphson method.
     * <p>
     * We use <i>C</i> to denote the integer whose square root is to be found.
     * Obviously, the square root of <i>C</i> is the zero point of the function.
     * <blockquote> y=f(x)=x^{2}-C </blockquote>
     * <p>
     * We choose x_{0}=C as the initial value. <br>
     * In each iteration, we find the point \left(x_{i}, x_{i}^{2}-C\right) on the
     * function image through the current intersection point x_{i}. <br>
     * Draw a straight line with a slope of f^{\prime}\left(x_{i}\right)=2 x_{i}.
     * <br>
     * The equation of the straight line is: <blockquote>
     *
     * <pre>
     *          \begin{aligned}
     *          y_{l} &=2 x_{i}\left(x-x_{i}\right)+x_{i}^{2}-C \\
     *          &=2 x_{i} x-\left(x_{i}^{2}+C\right)
     *          \end{aligned}
     * </pre>
     *
     * </blockquote>
     * <p>
     * The intersection with the horizontal axis is the solution of the equation
     * 2x_{i} x-\left(x_{i}^{2}+C\right)=0, which is the new iteration result
     * x_{i}+1: <blockquote>
     *
     * <pre>
     *      x_{i+1}=\frac{1}{2}\left(x_{i}+\frac{C}{x_{i}}\right)
     * </pre>
     *
     * </blockquote>
     *
     * @param x the value for which the square root needs to be calculated.
     * @return the square root of {@code x}.
     */
    public int mySqrt4(int x) {
        int result = 0;
        if (x != 0) {
            double x0 = x;
            while (true) {
                // Iterative formula.
                double half = 0.5;
                double xi = half * (x0 + (double)x / x0);
                /*
                 * When the intersection points of two adjacent iterations are very close, we
                 * can conclude that the result at this time is enough for us to get the answer,
                 * generally can be 10^-6 or 10^-7.
                 */
                double difference = 1e-7;
                if (Math.abs(x0 - xi) < difference) {
                    break;
                }
                x0 = xi;
            }
            result = (int)x0;
        }
        return result;
    }

}
