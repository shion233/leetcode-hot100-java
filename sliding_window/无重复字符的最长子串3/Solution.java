package sliding_window.无重复字符的最长子串3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
     * 做题思路：
     * - 用滑动窗口维护一个不含重复字符的区间 [i, j]。
     * - map 记录每个字符上一次出现位置的后一位，遇到重复字符时把左边界 i 跳到更靠右的位置。
     * - 每次扩展右边界后更新窗口长度最大值。
     */
    public int lengthOfLongestSubstring(String s) {
        int n=s.length(),ans=0;
        Map<Character,Integer> map= new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}