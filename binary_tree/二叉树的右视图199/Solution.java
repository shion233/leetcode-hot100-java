package binary_tree.二叉树的右视图199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 解法1是 BFS 层序遍历：右视图可以理解为每一层最右边的那个节点。
     * - 用队列记录当前层节点，每轮先保存 size，按从左到右处理这一层；当 i == size - 1 时，当前节点就是该层右视图节点。
     * - 解法2是 DFS：优先遍历右子树，再遍历左子树；当 level == res.size() 时，说明第一次到达这一层，记录当前节点。
     * - 两种写法本质都是按层取最右节点，BFS 更直观，DFS 利用“右子树优先”让每层第一个访问到的节点就是答案。
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.offerLast(node.left);
                if (node.right != null) queue.offerLast(node.right);
                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }
//    解法2:DFS
    public List<Integer> rightSideView1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        DFS(root,0,res);
        return res;
    }
    public void DFS(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) res.add(root.val);
        DFS(root.right, level + 1, res);
        DFS(root.left, level + 1, res);
    }


}
