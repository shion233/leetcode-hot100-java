package multidimensional_dp.最长回文子串5;

class Solution {
    /*
     * 做题思路：
     * - 回文子串可以用区间动态规划判断，关键是先知道内部子串 s[i + 1..j - 1] 是否为回文。
     * - dp[i][j] 表示从下标 i 到下标 j 的子串是否是回文串。
     * - 外层 i 从右往左遍历，是为了在计算 dp[i][j] 时，dp[i + 1][j - 1] 已经提前算好。
     * - 如果 s.charAt(i) == s.charAt(j)，并且内部子串是回文，或者当前长度 j - i + 1 不超过 3，就可以确定 dp[i][j] 为 true。
     * - start 记录当前最长回文子串的起点，maxlen 记录长度；每次发现更长的回文区间就更新这两个变量。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的二维动态规划做法。
     */
    public String longestPalindrome(String s) {
        int start = 0;
        int maxlen = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >=0; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)&&(dp[i+1][j-1]||j-i<=2)) {
                    dp[i][j] = true;
                }
                if (dp[i][j] && j-i+1 > maxlen) {
                    maxlen = j-i+1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxlen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("a"));
    }
}
