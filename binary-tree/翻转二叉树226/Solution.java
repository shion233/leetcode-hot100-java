package 翻转二叉树226;

public class Solution {
    /*
     * 做题思路：
     * - 翻转二叉树就是让每个节点的左右孩子交换。
     * - 当前节点交换完成后，再递归翻转新的左子树和右子树。
     * - 空节点直接返回，作为递归边界。
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
