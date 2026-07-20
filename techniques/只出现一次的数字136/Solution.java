package techniques.只出现一次的数字136;

class Solution {
    /*
     * 做题思路：
     * - 题目中除了一个数字只出现一次，其他数字都出现两次，适合使用异或运算的抵消特性。
     * - 异或有两个关键性质：x ^ x = 0，x ^ 0 = x，并且异或满足交换律和结合律。
     * - res 初始为 nums[0]，之后依次和数组里的其他数字异或。
     * - 出现两次的数字最终都会互相抵消成 0，只出现一次的数字不会被抵消，最后保留在 res 中。
     * - 代码没有注释掉的旧解法，当前思路是本题常见位运算技巧，时间复杂度 O(n)，额外空间 O(1)。
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.singleNumber(new int[]{4,1,2,1,2}));
    }
}
