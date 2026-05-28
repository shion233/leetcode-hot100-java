package binary_tree.路径总和III437;

import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    /*
     * 做题思路：
     * - 解法1把每个节点都当作路径起点：pathSum 负责枚举起点，countPathSum 负责从当前起点向下统计满足 targetSum 的路径。
     * - countPathSum 每向下一层，就把目标值减去当前节点值；当 root.val == targetSum 时，说明从起点到当前节点形成了一条合法路径。
     * - 做法2使用前缀和优化：curSum 表示从根到当前节点的路径和，如果之前出现过 curSum - target，说明中间某段路径和为 target。
     * - map 记录当前递归路径上每个前缀和出现次数，进入节点时加入 curSum，左右子树处理完后减回去，避免影响其他分支。
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int res = countPathSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }
    public int countPathSum(TreeNode root, long targetSum) {
        if(root == null) return 0;
        int count = 0;
        if(root.val == targetSum) count++;
        count += countPathSum(root.left, targetSum - root.val);
        count += countPathSum(root.right, targetSum - root.val);
        return count;
    }
//    做法2
    public int pathSum2(TreeNode root, int targetSum) {
        if(root == null) return 0;
        int res = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        res = dfs(root,targetSum,map,0);
        return res;
    }
    public int dfs(TreeNode root, long target, HashMap<Long, Integer> map,long curSum) {
        if(root == null) return 0;
        curSum += root.val;
        long need = curSum -target;
        int count = map.getOrDefault(need, 0);
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        count += dfs(root.left,target,map,curSum);
        count += dfs(root.right,target,map,curSum);
        map.put(curSum,map.get(curSum)-1);
        return count;
    }
}
