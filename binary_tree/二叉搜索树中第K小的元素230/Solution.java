package binary_tree.二叉搜索树中第K小的元素230;

class Solution {
    /*
     * 做题思路：
     * - 二叉搜索树的中序遍历结果是递增序列。
     * - 按中序顺序访问节点，并用 count 记录当前访问到第几个元素。
     * - 当 count 等于 k 时记录当前节点值，最终返回这个值。
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
    int count = 0;
    int val=0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        kthSmallest(root.left, k);
        count++;
        if (count == k) val = root.val;
        kthSmallest(root.right, k);
        return val;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        solution.kthSmallest(root, 1);
    }
}
