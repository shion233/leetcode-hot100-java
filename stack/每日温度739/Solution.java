package stack.每日温度739;

import java.util.ArrayDeque;

class Solution {
    /*
     * 做题思路：
     * - 题目要找每一天之后第一个更高温度相隔多少天，适合用单调栈保存“还没找到更高温度”的日期下标。
     * - stack 中存的是 temperatures 的下标，并且这些下标对应的温度从栈顶往下保持递增关系，也就是栈顶是最近且温度不高于后续待比较的日期。
     * - 遍历到第 i 天时，如果 temperatures[i] 大于栈顶下标对应的温度，说明第 i 天就是那个下标 pop 的第一个更高温度，answer[pop] = i - pop。
     * - 一个下标被弹出后答案就确定了；当前 i 处理完所有能被它更新的旧下标后，再把 i 入栈等待未来更高温度。
     * - 最后栈里剩下的下标表示后面没有更高温度，answer 默认就是 0。
     * - 注释掉的旧代码是我最初的解法：额外判断相邻两天温度来提前写 answer[i]，分支更多且容易把统一的单调栈流程拆散；当前解法所有日期都按同一规则入栈出栈，更清晰稳定。
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] >temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                answer[pop] = i-pop;
            }
            stack.push(i);
        }
        return  answer;
    }
//    public int[] dailyTemperatures(int[] temperatures) {
//        int[] answer = new int[temperatures.length];
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        for (int i = 0; i < temperatures.length; i++) {
//            while (!stack.isEmpty() && temperatures[i] >temperatures[stack.peek()]) {
//                Integer pop = stack.pop();
//                answer[pop] = i-pop;
//            }
//            if (i==temperatures.length-1)
//                break;
//            if (temperatures[i] >= temperatures[i+1]) {
//                stack.push(i);
//            }else {
//                answer[i] = 1;
//            }
//        }
//        return  answer;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] temperatures = {77,77,77,77,77,41,77,41,41,77};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
