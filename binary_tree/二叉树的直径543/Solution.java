package binary_tree.二叉树的直径543;

public class Solution {
    /*
     * 做题思路：
     * - 直径不一定经过根节点，所以要在求每个节点深度的过程中顺便更新答案。
     * - 对任意节点，经过它的最长路径长度等于左子树深度 + 右子树深度。
     * - maxdepth 返回当前节点向下能贡献的最大深度，成员变量 max 记录全局最大直径。
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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxdepth(root);
        return max;

    }
    public int maxdepth(TreeNode root){
        if (root == null) return 0;
        int l = maxdepth(root.left);
        int r = maxdepth(root.right);
        if(max<l+r){
            max=l+r;
        }
        return (l > r? l: r) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);

        // 第二层
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        // 第三层 (挂在节点 2 下面)
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5); // 1 的左右分别是 2 和 3
        solution.diameterOfBinaryTree(root);
    }
}
