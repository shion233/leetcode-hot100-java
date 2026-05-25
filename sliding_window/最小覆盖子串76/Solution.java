package sliding_window.最小覆盖子串76;

import java.util.HashMap;

class Solution {
    /*
     * 做题思路：
     * - 用滑动窗口在 s 中寻找覆盖 t 所有字符的最短区间。
     * - map 记录窗口还缺哪些字符，count 表示还需要匹配的字符总数。
     * - 右指针扩展直到窗口满足条件，再移动左指针尽量收缩；每次满足时更新最短答案。
     */
    public String minWindow(String s, String t) {
        String r = "";
        int left =0, right = 0;
        int lt=0,rt=0;
        int length=Integer.MAX_VALUE;
        int count = t.length();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] array = t.toCharArray();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        if (s.length() < t.length()) {
            return "";
        }
        if (s.length()==1&&t.length()==1) {
            if (s.equals(t))
                return s;
            else {
                return "";
            }
        }
        while (right<s.length()) {
            if(map.containsKey(s.charAt(right))) {
                if(map.get(s.charAt(right)) > 0) {
                    count--;
                }
                Integer i = map.get(s.charAt(right))-1;
                map.put(s.charAt(right), i);
            }
            right++;

            while(count==0) {
                if(right-left<length) {
                    lt=left;
                    rt=right;
                    length=right-left;
                }
                if(map.containsKey(s.charAt(left))) {
                    Integer i = map.get(s.charAt(left))+1;
                    map.put(s.charAt(left), i);
                    if(map.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        if (length!=Integer.MAX_VALUE) {
            r = s.substring(lt,rt);
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
