package greedy.跳跃游戏55;

class Solution {
    /*
     * 做题思路：
     * - 题目只关心能不能到达最后一个位置，不需要记录具体跳法，所以用贪心维护当前能覆盖到的最远下标。
     * - cover 表示从已经能到达的位置出发，当前最多能跳到哪里，初始值是 nums[0]。
     * - for 循环只遍历 i <= cover 的位置，因为超过 cover 的下标当前根本到不了。
     * - 每到一个可达位置 i，就用 i + nums[i] 尝试更新 cover，表示从当前位置再跳一次后的最远覆盖范围。
     * - 如果 cover 已经覆盖到 nums.length - 1，说明可以到达终点，直接返回 true；循环结束还没覆盖终点就返回 false。
     * - 代码没有注释掉的旧解法，当前思路是本题常见贪心做法，只需要一次遍历。
     */
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0)return false;
        if(nums.length==1)return true;
        int cover=nums[0];
        for (int i = 0; i <= cover; i++) {
            cover=Math.max(cover,i+nums[i]);
            if(cover>=nums.length-1)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{1,2}));
    }
}
