package 最长连续序列128;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 当前实现先排序并去重，再统计相邻数字是否连续。
     * - 遇到 array[i] + 1 == array[i + 1] 就延长当前连续段，否则用当前段长度更新最大值并重新计数。
     * - 这个思路直观但排序需要 O(n log n)；题目更优解通常用 HashSet 从连续段起点开始扩展到 O(n)。
     */
    public int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        Arrays.sort(nums);
        int max = 1;
        int count = 1;
        int[] array = Arrays.stream(nums).distinct().toArray();
        for (int i = 0; i < nums.length; i++) {
            if (i+1<array.length&&array[i] + 1 == array[i+1]) {
                count++;
            }else {
                if(count>max){
                    max=count;
                }
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(new int[]{1,0,1,2}));
    }
}
