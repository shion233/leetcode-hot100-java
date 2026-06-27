package greedy.跳跃游戏II45;

class Solution {
    /*
     * 做题思路：
     * - 题目要求到达最后一个位置的最少跳跃次数，可以把每一次跳跃看成覆盖一段当前可达区间。
     * - curend 表示当前已经使用 count 次跳跃后能到达的最远边界，nextend 表示在当前区间内再跳一步能到达的最远边界。
     * - 遍历 i 时，只在当前可达范围内更新 nextend = max(nextend, i + nums[i])，表示下一跳可以覆盖到的最远位置。
     * - 当 i 走到 curend，说明当前这一跳覆盖的区间已经扫描完，必须再跳一次，所以 count++，并把 curend 更新为 nextend。
     * - 循环只遍历到 nums.length - 2，因为到达最后一个位置后不需要继续起跳。
     * - 代码没有注释掉的旧解法，当前思路是本题常见贪心做法，每次都选择能让下一段覆盖范围最大的跳法。
     */
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int curend=0;
        int nextend=0;
        int count=0;
        for (int i = 0; i <= nextend&&i<nums.length-1; i++) {
            nextend=Math.max(nextend,i+nums[i]);
            if (i==curend) {
                count++;
                curend=nextend;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
    }
}
