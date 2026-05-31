package backtracking.子集78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 子集问题适合用回溯枚举所有“选或不选”的组合，path 保存当前已经选择的元素。
     * - 每进入一次 backtracking，都先把当前 path 拷贝进结果 list，因为从空集到任意长度的选择都算一个子集。
     * - start 表示下一次可以选择的起始下标，循环从 start 往后尝试，避免重复选择前面的元素。
     * - 每次选择 nums[i] 后递归到 i + 1，递归结束再 remove 最后一个元素，恢复现场后继续尝试下一个分支。
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        backtracking(list, path, nums, 0);
        return list;
    }
    public void backtracking(List<List<Integer>> list, ArrayList<Integer> path,int[] nums, int start) {
        list.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(list, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
