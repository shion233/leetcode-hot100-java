package multidimensional_dp.最长公共子序列1143;

class Solution {
    /*
     * 做题思路：
     * - 最长公共子序列要比较两个字符串的前缀关系，适合用二维动态规划。
     * - dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符之间的最长公共子序列长度。
     * - dp 数组多开一行一列，用 dp[0][j] 和 dp[i][0] 表示有一个字符串为空的情况，默认值就是 0。
     * - 当 text1.charAt(i - 1) == text2.charAt(j - 1) 时，说明这两个字符可以一起加入公共子序列，dp[i][j] = dp[i - 1][j - 1] + 1。
     * - 如果两个字符不相等，就分别尝试跳过 text1 当前字符或 text2 当前字符，取 dp[i - 1][j] 和 dp[i][j - 1] 的较大值。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的二维动态规划做法。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
    }
}
