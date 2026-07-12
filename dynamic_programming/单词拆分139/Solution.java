package dynamic_programming.单词拆分139;

import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 题目要判断字符串 s 能否被 wordDict 中的单词拼出来，可以用动态规划判断每个前缀是否可拆分。
     * - dp[i] 表示 s 的前 i 个字符，也就是 s.substring(0, i)，能否被字典中的单词完整拆分。
     * - dp[0] = true 表示空字符串可以被拆分，这是后续状态转移的起点。
     * - 枚举结束位置 i，再枚举切分点 j；如果 dp[j] 为 true，并且 s.substring(j, i) 在 wordDict 中，说明前 i 个字符也可以被拆分。
     * - 一旦找到可行切分，就把 dp[i] 置为 true；最后返回 dp[s.length()] 表示整个字符串是否可拆分。
     * - 代码没有注释掉的旧解法，当前思路是本题常见动态规划做法。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});
        System.out.println(solution.wordBreak("leetcode", wordDict));
    }
}
