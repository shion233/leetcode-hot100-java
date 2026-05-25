package array.合并区间56;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 先按区间左端点排序，让可能重叠的区间相邻。
     * - 维护当前合并区间，如果下一个区间左端点不超过当前右端点，就更新右端点为两者最大值。
     * - 如果不重叠，就把当前区间加入答案，并从下一个区间重新开始。
     */
    public int[][] merge(int[][] intervals) {
        int[][] result = new int[intervals.length][2];
        int count=0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] temp = intervals[0];
//        System.out.println(temp[0]+""+temp[1]);
//        for (int i = 0; i < intervals.length; i++) {
//            System.out.print(intervals[i][0] + " " + intervals[i][1]+" ");
//        }
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }
            else {
                result[count++]=temp;
                temp=intervals[i];
            }
        }
        result[count]=temp;
        int[][] result1 = new int[count+1][2];
        for (int i = 0; i <= count; i++) {
            result1[i]=result[i];
        }

        return  result1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] merge = s.merge(new int[][]{ {4,7},{1,4}});
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i][0] + " " + merge[i][1]+" ");
        }
    }
}