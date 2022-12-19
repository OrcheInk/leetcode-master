package pers.ricardolp.leetcode.easy.other;

/**
 * Binary tree node.
 *
 * @author RicardoLP
 * @since 2021/11/13
 */
public class TreeNode {

    /** Current node value. */
    public int val;

    /** The left subtree. */
    public TreeNode left;

    /** The right subtree. */
    public TreeNode right;

    TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return val + "";
    }

}
