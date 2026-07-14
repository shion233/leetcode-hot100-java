package dynamic_programming.乘积最大子数组152;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 乘积最大子数组和求和不同，遇到负数时，之前的最小乘积可能乘上负数后变成最大乘积。
     * - maxdp[i] 表示以 nums[i] 结尾的子数组能得到的最大乘积，mindp[i] 表示以 nums[i] 结尾的子数组能得到的最小乘积。
     * - 对于每个 nums[i]，要同时比较 nums[i] 自己、maxdp[i - 1] * nums[i]、mindp[i - 1] * nums[i]，分别更新当前位置的最大值和最小值。
     * - max 用来记录所有 maxdp[i] 中出现过的最大乘积，最终返回 max。
     * - 注释掉的旧代码是我最初的解法：枚举每个右端点 i，再向左不断累乘所有可能子数组，时间复杂度是 O(n^2)。
     * - 当前动态规划只需要一次遍历，时间复杂度降为 O(n)，并且通过同时维护最大和最小乘积正确处理负数翻转。
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = mindp[i-1] * nums[i];
            int temp2 = maxdp[i-1] * nums[i];
            maxdp[i] = temp > temp2 ? Math.max(temp,nums[i]) : Math.max(temp2,nums[i]);
            mindp[i] = temp < temp2 ? Math.min(temp,nums[i]) : Math.min(temp2,nums[i]);
            max = Math.max(max,maxdp[i]);
        }
        return max;
    }
//    public int maxProduct(int[] nums) {
//        int max = nums[0];
//        int[] dp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i] = nums[i];
//        }
//        for (int i = 1; i < dp.length; i++) {
//            int tmp = dp[i];
//            for (int j = i-1; j >= 0; j--) {
//                tmp *= nums[j];
//                dp[i] = Math.max(dp[i], tmp);
//            }
//            max = Math.max(dp[i],max);
//        }
//        return max;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[]{-2,3,-4}));
    }
}
