package stack.柱状图中最大的矩形84;

import java.util.ArrayDeque;

class Solution {
    /*
     * 做题思路：
     * - 对每根柱子来说，如果能找到它左边和右边第一个比它矮的位置，就能确定以它为高度的最大矩形宽度。
     * - stack 中保存柱子的下标，并维护对应高度单调递增；当当前高度 cur 小于栈顶高度时，说明栈顶柱子的右边界已经确定。
     * - 弹出的 temp 是当前要计算面积的柱子，高度是 heights[temp]；如果弹出后栈为空，宽度就是 i，否则宽度是 i - stack.peek() - 1。
     * - 循环走到 heights.length 时把 cur 当成 0，相当于在末尾加一个哨兵柱子，用来把栈里剩余柱子全部结算。
     * - 注释掉的旧代码是我最初的解法：枚举每个起点和终点，并维护区间最小高度计算面积，时间复杂度是 O(n^2)。
     * - 当前单调栈解法每个下标最多入栈、出栈一次，时间复杂度降为 O(n)，更适合本题。
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cur = 0;
        for (int i = 0; i <= heights.length; i++) {
            if (i<heights.length)
                cur = heights[i];
            else
                cur = 0;
            max = Math.max(max, cur);
            while (!stack.isEmpty() && heights[stack.peek()] > cur) {
                Integer temp = stack.pop();
                int width;
                if (stack.isEmpty())
                    width = i;
                else
                    width = i-stack.peek()-1;
                max = Math.max(max, width*heights[temp]);
            }
            if (i<heights.length) stack.push(i);
        }
        return max;
    }
//    public int largestRectangleArea(int[] heights) {
//        int max = 0;
//        for (int i = 0; i < heights.length; i++) {
//            int min = heights[i];
//            max = Math.max(max, heights[i]);
//            for (int j = i+1; j < heights.length; j++) {
//                min = Math.min(min, heights[j]);
//                max = Math.max(max, min*(j-i+1));
//            }
//           }
//        return max;
//        }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(new int[]{1,1}));
    }
}
