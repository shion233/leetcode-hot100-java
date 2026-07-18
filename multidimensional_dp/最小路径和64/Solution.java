package multidimensional_dp.最小路径和64;

class Solution {
    /*
     * 做题思路：
     * - 机器人只能向右或向下走，所以到达 grid[i][j] 的最小路径和只可能来自上方 dp[i - 1][j] 或左方 dp[i][j - 1]。
     * - dp[i][j] 表示从左上角走到第 i 行第 j 列时，路径上的最小数字和。
     * - dp[0][0] 先初始化为 grid[0][0]；第一列只能从上往下走，第一行只能从左往右走，所以分别单独累加初始化。
     * - 对其余位置，取上方和左方的较小路径和，再加上当前格子的 grid[i][j]。
     * - 注释掉的旧代码是我最初的解法：在统一双层循环中用 Integer.MAX_VALUE 处理上方和左方不存在的边界。
     * - 旧解法能做，但边界判断更多；当前解法先处理第一行和第一列，主递推只保留核心转移，逻辑更清晰。
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // 第一列只能从上方到达
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 第一行只能从左方到达
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // 其余位置可以从上方或左方到达
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] =
                        Math.min(dp[i - 1][j], dp[i][j - 1])
                                + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m][n];
//        dp[0][0] = grid[0][0];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0) {
//                    continue;
//                }
//                int up = Integer.MAX_VALUE;
//                int left = Integer.MAX_VALUE;
//                if (i >=1) {
//                    up = dp[i-1][j];
//                }
//                if (j >=1) {
//                    left =dp[i][j-1];
//                }
//                dp[i][j] = Math.min(up, left) + grid[i][j];
//            }
//        }
//        return dp[m-1][n-1];
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
