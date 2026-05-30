package binary_tree.二叉树中的最大路径和124;

class Solution {
    /*
     * 做题思路：
     * - 最大路径可以经过某个节点后同时连接左子树和右子树，所以用后序递归先计算左右子树能贡献的最大路径和。
     * - dfs 返回的是当前节点向父节点能提供的最大单边贡献，只能选择 left 或 right 中较大的一边继续向上延伸。
     * - 如果某一侧子树贡献为负数，就用 Math.max(..., 0) 舍弃这条路径，避免它拉低总和。
     * - max 记录全局答案，每个节点都尝试作为路径最高拐点，用 root.val + left + right 更新最大路径和。
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
    int max;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        max=root.val;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left =Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        max = Math.max(max,root.val+left+right);
        return root.val + Math.max(left, right);
    }
}
