package dynamic_programming.零钱兑换322;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 题目要求用 coins 中的硬币凑出 amount，且每种硬币可以重复使用，这是典型的完全背包动态规划。
     * - dp[i] 表示凑出金额 i 所需要的最少硬币数量，初始化为 amount + 1 表示当前金额暂时无法凑出。
     * - dp[0] = 0 表示凑出金额 0 不需要任何硬币，这是后续状态转移的起点。
     * - 外层枚举金额 i，内层遍历每个 coin；如果 i >= coin，就可以尝试从 dp[i - coin] 再加一枚 coin 转移过来。
     * - 转移公式是 dp[i] = Math.min(dp[i], dp[i - coin] + 1)，不断保留凑出金额 i 的最少硬币数。
     * - 最后如果 dp[amount] 仍然是 amount + 1，说明无法凑出目标金额，返回 -1；代码没有注释掉的旧解法，当前思路是本题常见动态规划做法。
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{1}, 0));
    }
}
