package backtracking.分割回文串131;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 分割回文串需要枚举字符串的所有切割方案，适合用回溯从 start 位置开始尝试每一个可能的下一段。
     * - path 保存当前已经切出来的回文子串，start 表示下一次切割应该从 s 的哪个下标开始。
     * - 每次取 s.substring(start, i) 作为候选片段，只有它是回文串时才加入 path 并继续从 i 位置递归。
     * - 当 start == s.length() 时，说明整个字符串已经被合法切完，把 path 拷贝到结果；递归返回后移除最后一段恢复现场。
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        int start = 0;
        backtracking(s, path, start, res);
        return res;
    }
    public void backtracking(String s,List<String> path,int start, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1 + start; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            if (ispalindrome(substring)) {
                path.add(substring);
                backtracking(s, path, i, res);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean ispalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
    }
}
