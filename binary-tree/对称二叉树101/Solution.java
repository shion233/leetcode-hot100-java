package 对称二叉树101;

class Solution {
    /*
     * 做题思路：
     * - 判断一棵树是否对称，本质是判断根的左右子树是否互为镜像。
     * - 两个节点同时为空说明这一侧匹配；只有一个为空或值不同就不对称。
     * - 递归时交叉比较：左子树的左节点要对应右子树的右节点，左子树的右节点要对应右子树的左节点。
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
