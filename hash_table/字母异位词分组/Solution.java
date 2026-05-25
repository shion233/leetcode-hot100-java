package hash_table.字母异位词分组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 判断两个字符串是否为字母异位词，可以把字符排序后比较。
     * - 当前实现用 booleans 标记还没有被分组的字符串，外层选一个基准词，内层寻找所有与它排序后相同的词。
     * - 这种写法直观；更常见的优化是用排序后的字符串作为 HashMap 的 key，一次遍历完成分组。
     */
    public static void main(String[] args) {
        String []strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(strs);
        System.out.println(lists);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] booleans = new boolean[strs.length];
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; i++) {
            booleans[i] = true;
        }

        for (int i = 0; i < strs.length; i++) {
            if(!booleans[i])
                continue;
            ArrayList<String> list = new ArrayList<>();
            list.add(strs[i]);
            booleans[i] = false;
            for (int j = i+1; j < strs.length; j++) {
                if (strs[i].length()!=strs[j].length()) {
                    continue;
                }
                char[] ci = strs[i].toCharArray();
                char[] cj = strs[j].toCharArray();
                Arrays.sort(ci);
                Arrays.sort(cj);
                if(Arrays.equals(ci,cj)) {
                    booleans[j] = false;
                    list.add(strs[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}