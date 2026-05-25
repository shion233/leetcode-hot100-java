package binary_tree.将有序数组转换为二叉搜索树108;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 有序数组转平衡 BST，关键是每次选择中间元素作为当前根节点。
     * - 中间左侧递归构造左子树，中间右侧递归构造右子树。
     * - 这样左右子树规模尽量接近，构造出的树自然满足高度平衡。
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int length = nums.length;
        TreeNode node = sortedArrayToBST2(nums, 0, length - 1);
        return node;
    }
    public TreeNode sortedArrayToBST2(int[] nums,int low,int high) {
        if (low > high) return null;
        int mid = (low + high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST2(nums, low, mid - 1);
        node.right = sortedArrayToBST2(nums, mid + 1, high);
        return node;
    }
}