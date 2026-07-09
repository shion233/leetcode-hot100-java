package dynamic_programming.打家劫舍198;

class Solution {
    /*
     * 做题思路：
     * - 相邻房屋不能同时偷，所以到第 i 间房时只有两种选择：偷当前房屋，或者不偷当前房屋。
     * - dp[i] 表示从第 0 间到第 i 间房屋中，能偷到的最大金额。
     * - 如果偷第 i 间，就不能偷第 i - 1 间，金额是 dp[i - 2] + nums[i]；如果不偷第 i 间，金额就是 dp[i - 1]。
     * - 状态转移为 dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1])。
     * - nums.length == 1 时直接返回 nums[0]；dp[0] 和 dp[1] 分别作为递推起点。
     * - 代码没有注释掉的旧解法，当前思路是本题常见动态规划做法。
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{2,7,9,3,1}));
    }
}
