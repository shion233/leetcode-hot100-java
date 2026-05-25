package binary_tree.二叉树的最大深度104;

class Solution {
    /*
     * 做题思路：
     * - 树的最大深度可以拆成左右子树最大深度的较大值再加上当前根节点这一层。
     * - 空节点深度为 0，是递归终止条件。
     * - 后序递归先拿到左右深度，再返回当前子树深度。
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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l=maxDepth(root.left);
        int r=maxDepth(root.right);
        return (l>r?l:r)+1;
    }
}