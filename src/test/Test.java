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

        List<Integer> list1 = test.postorderTraversal(root);
        System.out.println(list1.toString());

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        TreeNode current = root, predecessor;

        while (current != null) {

            predecessor = current.left;

            if (predecessor != null) {

                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {

                    predecessor.right = current;
                    current = current.left;
                    continue;

                } else {
                    predecessor.right = null;
                    addSubtree(res, current.left);
                }
            }
            current = current.right;
        }
        addSubtree(res, root);
        return res;
    }

    public void addSubtree(List<Integer> res, TreeNode node) {

        int count = 0;

        // Add the node of the current subtree to the list.
        while (node != null) {

            count++;

            res.add(node.val);
            node = node.right;
        }

        // Calculate the index of the leftmost and rightmost node added.
        int left = res.size() - count, right = res.size() - 1;

        // Reverse the order of added nodes.
        while (left < right) {

            int temp = res.get(left);

            res.set(left, res.get(right));
            res.set(right, temp);

            // Move index.
            left++;
            right--;
        }
    }

}
