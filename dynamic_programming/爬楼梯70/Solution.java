package dynamic_programming.爬楼梯70;

class Solution {
    /*
     * 做题思路：
     * - 到第 i 阶楼梯的最后一步只有两种情况：从第 i - 1 阶爬 1 步上来，或者从第 i - 2 阶爬 2 步上来。
     * - dp[i] 表示爬到第 i 阶一共有多少种不同方法，因此状态转移就是 dp[i] = dp[i - 1] + dp[i - 2]。
     * - n <= 2 时答案就是 n，直接返回，避免后面初始化 dp[1]、dp[2] 时处理小数组边界。
     * - 从 i = 3 开始递推到 n，最终 dp[n] 就是爬到第 n 阶的方法数。
     * - 代码没有注释掉的旧解法，当前思路是本题常见动态规划做法，本质上和斐波那契数列一致。
     */
    public int climbStairs(int n) {
        if (n<=2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(1));
    }
}
