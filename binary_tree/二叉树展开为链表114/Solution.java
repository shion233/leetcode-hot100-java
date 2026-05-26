package binary_tree.二叉树展开为链表114;

class Solution {
    /*
     * 做题思路：
     * - 解法1按先序遍历顺序原地串链表：先保存当前节点的 left 和 right，再把当前节点接到 pre.right 后面。
     * - pre 表示已经展开好的链表尾节点，每处理一个节点就把它的 left 置空、right 置空，再接到 pre 后并更新 pre。
     * - 因为当前节点的左右指针会被改掉，所以递归前必须先用 left、right 临时保存原来的左右子树。
     * - 做法2是反向递归思路：按右子树、左子树、当前节点的顺序处理，让 pre 始终指向已经展开好的链表头，
     *   当前节点的 right 接到 pre，left 置空后再把 pre 更新为当前节点。
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

    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        pre = new TreeNode();
        preorder(root);
    }
    public void preorder(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        pre.right = root;
        pre = pre.right;
        preorder(left);
        preorder(right);
    }

//    做法2:递归
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;   // 当前节点的右边接上已经整理好的链表
        root.left = null;   // 左边置空
        pre = root;         // 更新链表头节点为当前节点
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        solution.flatten(root);
    }
}
