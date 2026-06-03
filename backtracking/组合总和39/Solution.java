package backtracking.组合总和39;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 组合总和需要枚举若干数字凑出 target，适合用回溯维护当前组合 path 和剩余目标值 target。
     * - start 表示当前这一层可以从 candidates 的哪个下标开始选，避免同一组数字因为顺序不同被重复加入结果。
     * - 题目允许同一个数字重复使用，所以递归时下一层仍然传入 i，而不是 i + 1。
     * - 当 target == 0 时，说明 path 中的数字刚好凑成目标值，拷贝 path 加入结果；当 target - candidates[i] < 0 时跳过该选择。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtracking(candidates, target,0 ,path, res);
        return res;
    }
    public void backtracking(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                path.add(candidates[i]);
                backtracking(candidates, target - candidates[i], i, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res.toString());
    }
}
