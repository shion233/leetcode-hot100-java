package greedy.划分字母区间763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 每个字母最多只能出现在同一个片段中，所以一个片段的右边界必须覆盖片段内所有字母的最后出现位置。
     * - last 数组记录 26 个小写字母在 s 中最后一次出现的下标，比用 HashMap 更轻量。
     * - left 表示当前片段的起点，right 表示当前片段必须覆盖到的最远位置。
     * - 遍历到下标 i 时，用当前字符的最后出现位置 charLastPosition 更新 right，保证当前片段包含这个字符的所有出现。
     * - 当 i == right 时，说明从 left 到 right 之间所有字符的最后出现位置都没有超出 right，可以切出一个片段并记录长度。
     * - 注释掉的旧代码是我最初的解法：用 HashMap<String, Integer> 记录最后位置，思路一致但对象创建和哈希访问更重；当前数组写法更直接。
     */
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>(26);
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int charLastPosition = last[s.charAt(i) - 'a'];
            right = Math.max(right, charLastPosition);
            if (i == right) {
                result.add(right - left + 1);
                left = i + 1;
            }
        }

        return result;
    }
//    public List<Integer> partitionLabels(String s) {
//        if(s==null||s.length()==0) return new ArrayList<>();
//        ArrayList<Integer> res = new ArrayList<>();
//        int right=0;
//        int prev=0;
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            map.put(String.valueOf(s.charAt(i)),i);
//        }
//        for (int i = 0; i < s.length(); i++) {
//            right= Math.max(right,map.get(String.valueOf(s.charAt(i))));
//            if (i==right) {
//                int length=i-prev+1;
//                prev=i+1;
//                res.add(length);
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        List<Integer> list = new Solution().partitionLabels("eccbbbbdec");
        System.out.println(list);
    }
}
