package pers.ricardolp.leetcode.easy;

import java.util.*;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * leetcode_100 : Same Tree.
 * <p>
 * Given the roots of two binary trees {@code p} and {@code q}, write a function
 * to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 *
 * <pre>
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 *
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * </pre>
 *
 * Constraints:
 * <p>
 * The number of nodes in both trees is in the range [0, 100]. <br>
 * -10<sup>4</sup> {@code <=} Node.val {@code <=} 10<sup>4</sup>
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class SameTree100 {

    /**
     * Solution1.
     * <p>
     * Depth-first search.
     *
     * @param p the binary tree.
     * @param q the binary tree.
     * @return {@code true} if {@code p} and {@code q} are equal,{@code false}
     *         otherwise.
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }

    /**
     * Solution2.
     * <p>
     * Breadth-first search.
     *
     * @param p the binary tree.
     * @param q the binary tree.
     * @return {@code true} if {@code p} and {@code q} are equal,{@code false}
     *         otherwise.
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        boolean result = true;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();

            if (p == null && q == null) {
                continue;
            }

            boolean condiiton = (p == null || q == null) || p.val != q.val;
            if (condiiton) {
                result = false;
                break;
            }

            queue.offer(p.left);
            queue.offer(q.left);

            queue.offer(p.right);
            queue.offer(q.right);
        }
        return result;
    }

    /**
     * Solution3.
     * <p>
     * Recursive pre-order traversal.
     *
     * @param p the binary tree.
     * @param q the binary tree.
     * @return {@code true} if {@code p} and {@code q} are equal,{@code false}
     *         otherwise.
     */
    public boolean isSameTree3(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        preOrderTraversal(p, list1);
        preOrderTraversal(q, list2);

        return list1.equals(list2);
    }

    /**
     * Solution4.
     * <p>
     * Recursive post-order traversal.
     *
     * @param p the binary tree.
     * @param q the binary tree.
     * @return {@code true} if {@code p} and {@code q} are equal,{@code false}
     *         otherwise.
     */
    public boolean isSameTree4(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        postOrderTraversal(p, list1);
        postOrderTraversal(q, list2);

        return list1.equals(list2);
    }

    /**
     * Solution5.
     * <p>
     * Recursive in-order traversal.
     *
     * @param p the binary tree.
     * @param q the binary tree.
     * @return {@code true} if {@code p} and {@code q} are equal,{@code false}
     *         otherwise.
     */
    public boolean isSameTree5(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        while (p != null || q != null || !stackP.isEmpty() || !stackQ.isEmpty()) {

            if (p != null && q != null) {

                stackP.add(p);
                stackQ.add(q);

                p = p.left;
                q = q.left;

            } else if (q == null && p == null) {

                p = stackP.pop();
                q = stackQ.pop();

                if (p.val != q.val) {
                    return false;
                }

                p = p.right;
                q = q.right;

            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Recursive pre-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    private void preOrderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            list.add(root.val);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        } else {
            list.add(null);
        }

    }

    /**
     * Recursive post-order traversal.
     *
     * @param list the list for storing result.
     * @param root the root of the binary tree.
     */
    private void postOrderTraversal(TreeNode root, List<Integer> list) {

        if (root != null) {
            postOrderTraversal(root.left, list);
            postOrderTraversal(root.right, list);
            list.add(root.val);
        } else {
            list.add(null);
        }

    }
}
