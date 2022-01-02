import java.util.ArrayList;
import java.util.List;

import pers.ricardolp.leetcode.easy.other.TreeNode;

/**
 * Test Class.
 *
 * @author RicardoLP
 * @since 2021/12/3
 */
public class Test {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        String answer = "[4, 5, 2, 6, 7, 3, 1]";

        Test test = new Test();
        List<Integer> list = test.postOrderTraversal(root);

        System.out.println(list.toString());

    }

    public List<Integer> preOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root != null) {

            TreeNode cur = root, predecessor;

            while (cur != null) {
                if (cur.left != null) {
                    predecessor = cur.left;

                    while (predecessor.right != null && predecessor.right != cur) {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null) {
                        predecessor.right = cur;

                        // add preorder
                        res.add(cur.val);

                        cur = cur.left;
                    } else {
                        predecessor.right = null;
                        cur = cur.right;
                    }
                } else {

                    // add preorder
                    res.add(cur.val);

                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root != null) {

            TreeNode cur = root, predecessor;
            while (cur != null) {
                if (cur.left != null) {
                    predecessor = cur.left;

                    while (predecessor.right != null && predecessor.right != cur) {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null) {
                        predecessor.right = cur;
                        cur = cur.left;
                    } else {
                        predecessor.right = null;

                        // Add inorder
                        res.add(cur.val);

                        cur = cur.right;
                    }
                } else {

                    // Add inorder
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root != null) {

            TreeNode cur = root, predecessor;

            while (cur != null) {

                if (cur.left != null) {
                    predecessor = cur.left;

                    while (predecessor.right != null && predecessor.right != cur) {
                        predecessor = predecessor.right;
                    }

                    if (predecessor.right == null) {
                        predecessor.right = cur;
                        cur = cur.left;
                    } else {
                        predecessor.right = null;

                        // Add postorder
                        addSubtree(res, cur.left);

                        cur = cur.right;
                    }
                } else {
                    cur = cur.right;
                }
            }
        }
        // Add postorder
        addSubtree(res, root);
        return res;
    }

    private void addSubtree(List<Integer> res, TreeNode root) {

        int count = 0;

        while (root != null) {
            count++;
            res.add(root.val);
            root = root.right;
        }

        int left = res.size() - count, right = res.size() - 1;

        while (left < right) {
            int temp = res.get(left);

            res.set(left, res.get(right));
            res.set(right, temp);

            left++;
            right--;
        }

    }

}
