package binary_tree.验证二叉搜索树98;

class Solution {
    /*
     * 做题思路：
     * - 当前采用中序遍历法：合法 BST 的中序遍历结果必须严格递增。
     * - prev 保存上一个访问到的节点值，如果当前值小于等于 prev，就说明不满足 BST。
     * - 注释掉的范围法也是标准解法：递归时给每个节点维护允许的取值上下界。
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
//    中序法
    Integer prev = null; // 必须是成员变量，或者用单元素数组在参数中传递引用

    boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // 1. 先递归左子树，如果左子树不合法，直接返回 false
        if (root.left!=null){
            boolean l = isValidBST(root.left);
            if (!l)
                return false;
        }
        // 2. 处理当前节点：
        //    - 如果 prev != null 且 当前节点值 <= prev，返回 false
        //    - 否则更新 prev = 当前节点值
        if (prev != null&&root.val<=prev)
            return false;
        prev = root.val;
        // 3. 再递归右子树，并返回右子树的结果
        if (root.right!=null){
            boolean r = isValidBST(root.right);
            if (!r)
                return false;
        }
        return  true;
    }
//    范围法
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        return isValidHelper(root,Long.MIN_VALUE,Long.MAX_VALUE);
//    }
//    public boolean isValidHelper(TreeNode root, long low, long high) {
//        if (root == null) return true;
//        if (root.val <= low || root.val >= high) return false;
//        return isValidHelper(root.left, low, root.val)&&isValidHelper(root.right, root.val, high);
//    }
}
