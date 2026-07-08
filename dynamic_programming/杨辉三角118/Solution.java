package dynamic_programming.杨辉三角118;

import java.util.ArrayList;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 杨辉三角的每一行都依赖上一行，中间位置等于上一行左上和右上两个数之和，符合动态规划的递推思想。
     * - res 保存已经生成的所有行，当前正在构造的 list 表示第 i 行。
     * - 每一行的第一个位置 j == 0 和最后一个位置 j == i 都固定是 1，直接加入 list。
     * - 中间位置通过 res.get(i - 1).get(j) + res.get(i - 1).get(j - 1) 计算，再加入当前行。
     * - 当前行 list 构造完成后加入 res，后续行就可以继续基于它计算。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的逐行递推做法。
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i) {
                    list.add(1);
                }else {
                    int tmp = res.get(i-1).get(j)+res.get(i-1).get(j-1);
                    list.add(tmp);
                }
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(4));
    }
}
