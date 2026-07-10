package dynamic_programming.完全平方数279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 题目要用最少数量的完全平方数凑出 n，可以把每个平方数看成可以重复使用的物品，因此当前解法按完全背包来做。
     * - dp[j] 表示凑出整数 j 所需的最少完全平方数个数，先把 dp 填成 n + 1 作为无穷大，dp[0] = 0 表示凑出 0 不需要任何数。
     * - squares 先保存所有不超过 n 的完全平方数，避免在转移时重复计算 i * i。
     * - 外层枚举 square，内层 j 从 square 到 n 正向遍历，表示当前 square 可以被重复选择。
     * - 转移公式是 dp[j] = Math.min(dp[j], dp[j - square] + 1)，含义是在已有 j - square 的最优结果上再加一个 square。
     * - 标注“解法1”的 numSquares1 是旧思路：按每个目标值 i 逐个尝试所有不超过 i 的平方数，状态含义一致，但当前完全背包写法更贴近“平方数可重复使用”的模型。
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        for (int square : squares) {
            for (int j = square; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }

        return dp[n];
    }
//    解法1
    public int numSquares1(int n) {
        if(n==1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            squares.add(i*i);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j<squares.size()&&squares.get(j) <= i; j++) {
                dp[i]=Math.min(dp[i],dp[i-squares.get(j)]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(13));
    }
}
