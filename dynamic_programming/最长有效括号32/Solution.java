package dynamic_programming.最长有效括号32;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 最长有效括号可以用动态规划处理，关键是只统计“以当前位置 i 结尾”的有效括号长度。
     * - dp[i] 表示以 s.charAt(i) 结尾的最长有效括号子串长度；如果当前位置是 '('，它不可能作为有效括号结尾，dp[i] 保持 0。
     * - 当 s.charAt(i) == ')' 且前一个字符是 '(' 时，形成一对 "()"，长度是前面 dp[i - 2] 的结果再加 2。
     * - 当前一个字符也是 ')' 时，先用 left = i - dp[i - 1] - 1 找到上一段有效括号前面可能匹配当前 ')' 的位置。
     * - 如果 left 位置存在且是 '('，就能把 dp[i - 1] 这一段包起来，再加 2；如果 left 前面还有有效括号，还要继续接上 dp[left - 1]。
     * - max 在遍历中记录所有 dp[i] 的最大值；代码没有注释掉的旧解法，当前思路是本题常见动态规划做法。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int [] dp = new int[s.length()];
        int max = 0;
        Arrays.fill(dp,0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    int left = i - dp[i - 1]-1;
                    if (left >= 0 && s.charAt(left) == '(') {
                        dp[i] = dp[i-1] + 2;
                        if (left>=1){
                            dp[i]+=dp[left-1];
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("(()())"));
    }
}
