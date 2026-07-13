package dynamic_programming.最长递增子序列300;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 最长递增子序列可以用动态规划处理，关键是固定“以某个位置结尾”后，前面的状态就能转移过来。
     * - dp[i] 表示以 nums[i] 作为结尾时，能得到的最长递增子序列长度。
     * - 每个元素单独都可以构成长度为 1 的递增子序列，所以先用 Arrays.fill(dp, 1) 初始化。
     * - 对每个 i，枚举它前面的所有 j；如果 nums[i] > nums[j]，说明 nums[i] 可以接在以 nums[j] 结尾的递增子序列后面。
     * - 状态转移为 dp[i] = Math.max(dp[i], dp[j] + 1)，res 则持续记录所有 dp[i] 中的最大值。
     * - 代码没有注释掉的旧解法，当前思路是本题常见动态规划做法，时间复杂度为 O(n^2)。
     */
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{0}));
    }
}
