package multidimensional_dp.不同路径62;

class Solution {
    /*
     * 做题思路：
     * - 机器人只能向右或向下走，所以到达任意格子 (i, j) 的路径只可能来自上方 (i - 1, j) 或左方 (i, j - 1)。
     * - dp[i][j] 表示从左上角走到第 i 行第 j 列这个格子的不同路径数量。
     * - 第一列只能一直向下走到达，所以 dp[i][0] 都是 1；第一行只能一直向右走到达，所以 dp[0][j] 都是 1。
     * - 从 (1, 1) 开始递推，每个格子的路径数等于上方路径数加左方路径数，即 dp[i][j] = dp[i - 1][j] + dp[i][j - 1]。
     * - 最终 dp[m - 1][n - 1] 就是到达右下角的路径总数。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的二维动态规划做法。
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
    }
}
