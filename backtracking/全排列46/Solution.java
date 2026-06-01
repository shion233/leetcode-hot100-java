package backtracking.全排列46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 全排列需要枚举每个位置可以放哪个数，适合用回溯逐层构造一个完整排列。
     * - path 保存当前已经选出的排列前缀，visited 记录 nums 中哪些下标已经被使用，避免同一个元素在一次排列里重复出现。
     * - 当 path.size() == nums.length 时，说明当前排列已经完整，需要拷贝一份加入结果集。
     * - 每次选择 nums[i] 后标记 visited[i]，递归结束后再移除 path 最后一个元素并取消标记，恢复现场继续尝试其他分支。
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(visited,res,path,nums);
        return res;
    }
    public void backtracking(boolean[] visited, List<List<Integer>> list, ArrayList<Integer> path,int[] nums) {
        if (path.size() == nums.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                path.add(nums[i]);
                visited[i] = true;
                backtracking(visited, list, path, nums);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = solution.permute(new int[]{1,2,3});
    }
}
