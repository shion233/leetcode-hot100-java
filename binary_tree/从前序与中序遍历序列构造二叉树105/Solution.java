package binary_tree.从前序与中序遍历序列构造二叉树105;

import java.util.HashMap;

public class Solution {
    /*
     * 做题思路：
     * - 前序遍历的第一个元素一定是当前子树根节点，中序遍历中根节点左边是左子树，右边是右子树。
     * - map 记录每个值在中序数组中的下标，helper 用 prestart、preend 和 instart、inend 表示当前要构造的前序/中序区间。
     * - 找到根节点在中序中的位置 mid 后，左子树长度为 mid - instart，据此切分前序区间并递归构造左右子树。
     * - 当区间为空时返回 null，递归不断缩小区间，最终拼回完整二叉树。
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
    HashMap<Integer, Integer> map;
    int [] pre;
    int [] in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        if (preorder.length == 1 && inorder.length == 1)
            return new TreeNode(preorder[0]);
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        in = inorder;
        int prestart =0, instart =0, preend = preorder.length - 1, inend = preorder.length - 1;
        return helper(prestart,instart,preend,inend);
    }
    public TreeNode helper(int prestart, int instart, int preend, int inend) {
        if (prestart > preend || instart > inend)
            return null;
        TreeNode root = new TreeNode(pre[prestart]);
        int mid = map.get(pre[prestart]);
        int llenth = mid - instart;
        int rlehth = inend - mid;
        root.left = helper(prestart+1,instart,prestart+llenth,mid-1);
        root.right = helper(prestart+llenth+1,mid+1,preend,inend);
        return root;
    }
}
