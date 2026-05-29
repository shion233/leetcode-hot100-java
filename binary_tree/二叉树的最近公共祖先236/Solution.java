package binary_tree.二叉树的最近公共祖先236;

class Solution {
    /*
     * 做题思路：
     * - 用后序递归在每棵子树里寻找 p 和 q，函数返回值表示当前子树中是否找到了目标节点或最近公共祖先。
     * - 如果 root 为空返回 null；如果 root 本身就是 p 或 q，直接返回 root，表示当前子树已经找到一个目标。
     * - 分别递归左右子树：如果 left 和 right 都不为空，说明 p、q 分别在当前节点两侧，当前 root 就是最近公共祖先。
     * - 如果只有一侧不为空，就把这一侧结果向上返回；如果两侧都为空，说明当前子树没有 p 或 q。
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else if (right != null) return right;
        else return null;
    }
}
