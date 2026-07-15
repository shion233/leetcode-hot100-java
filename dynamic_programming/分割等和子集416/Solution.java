package dynamic_programming.分割等和子集416;

class Solution {
    /*
     * 做题思路：
     * - 要把数组分成两个和相等的子集，等价于判断能否从 nums 中选出一部分数字，使它们的和等于总和的一半 target。
     * - 如果 sum 是奇数，或者数组只有一个元素，就不可能分成两个和相等的非空子集，直接返回 false。
     * - dp[j] 表示使用已经遍历过的数字时，是否可以凑出和为 j 的子集；dp[0] = true 表示什么都不选可以凑出 0。
     * - 每个 nums[i] 只能使用一次，所以内层 j 必须从 target 倒序遍历到 nums[i]，避免同一个数字在一轮中被重复使用。
     * - 状态转移为 dp[j] = dp[j] || dp[j - nums[i]]，意思是 j 可以由之前已经能凑出的 j，或者加上当前 nums[i] 后凑出。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的 0/1 背包动态规划做法。
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1||nums.length==1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartition(new int[]{1,5,11,5}));
    }
}
