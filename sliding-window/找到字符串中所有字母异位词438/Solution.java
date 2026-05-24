package 找到字符串中所有字母异位词438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 当前实现把 p 排序后，枚举 s 中每个长度为 p.length() 的子串并排序比较。
     * - 如果排序后的字符数组相等，说明该窗口是 p 的字母异位词，记录起始下标。
     * - 文件底部注释里的推荐解法是更优的滑动窗口频次数组：窗口每次只进一个字符、出一个字符，
     *   避免每个窗口都重新排序。
     */
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0;
        char[] array = p.toCharArray();
        Arrays.sort(array);
        while (i<=s.length()-p.length()){
            String s1 = s.substring(i, p.length()+i);
            char[] array1 = s1.toCharArray();
            Arrays.sort(array1);
            if(Arrays.equals(array,array1)){
                list.add(i);
            }
            i++;
        }
        return  list;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
    }
}
//        推荐解法
//
//class Solution {
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list = new ArrayList<>();
//
//        int n = s.length();
//        int m = p.length();
//
//        if (n < m) {
//            return list;
//        }
//
//        int[] need = new int[26];
//        int[] window = new int[26];
//
//        // 统计 p 中字符频次
//        for (int i = 0; i < m; i++) {
//            need[p.charAt(i) - 'a']++;
//        }
//
//        // 先统计 s 的第一个窗口
//        for (int i = 0; i < m; i++) {
//            window[s.charAt(i) - 'a']++;
//        }
//
//        // 判断第一个窗口
//        if (Arrays.equals(need, window)) {
//            list.add(0);
//        }
//
//        // 开始滑动窗口
//        for (int i = m; i < n; i++) {
//            // 新字符进入窗口
//            window[s.charAt(i) - 'a']++;
//
//            // 旧字符离开窗口
//            window[s.charAt(i - m) - 'a']--;
//
//            // 比较两个频次数组
//            if (Arrays.equals(need, window)) {
//                list.add(i - m + 1);
//            }
//        }
//
//        return list;
//    }
//}