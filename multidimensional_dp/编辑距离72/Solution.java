package multidimensional_dp.编辑距离72;

class Solution {
    /*
     * 做题思路：
     * - 编辑距离要比较两个字符串前缀之间的最少操作次数，适合用二维动态规划。
     * - dp[i][j] 表示把 word1 的前 i 个字符转换成 word2 的前 j 个字符所需的最少操作数。
     * - 当 word2 为空时，word1 前 i 个字符只能全部删除，所以 dp[i][0] = i；当 word1 为空时，只能插入 word2 前 j 个字符，所以 dp[0][j] = j。
     * - 如果 word1.charAt(i - 1) == word2.charAt(j - 1)，当前字符相同，不需要额外操作，直接继承 dp[i - 1][j - 1]。
     * - 如果当前字符不同，就在删除 dp[i - 1][j]、替换 dp[i - 1][j - 1]、插入 dp[i][j - 1] 三种操作中取最小值再加 1。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的二维动态规划做法。
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else  {
                    dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i - 1][j-1], dp[i][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
    }
}
