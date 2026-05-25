package array.缺失的第一个正数41;

class Solution {
    /*
     * 做题思路：
     * - 缺失的第一个正数只可能出现在 1 到 n + 1 之间。
     * - 把每个合法数字 x 尽量放到下标 x - 1 的位置上，形成“值和下标对应”的状态。
     * - 再从左到右找第一个 nums[i] != i + 1 的位置，答案就是 i + 1；如果都匹配，答案是 n + 1。
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
//            while(nums[i] > 0 && nums[i] <=nums.length&&nums[i]!=i+1){
//            假如 nums[i] 已经在正确位置，那么 nums[i] == i+1，而 nums[nums[i]-1] = nums[(i+1)-1] = nums[i]，所以 nums[i] == nums[nums[i]-1]，不满足交换条件，循环结束。
            while(nums[i] > 0 && nums[i] <=nums.length&&nums[i]!=nums[nums[i]-1]){
//                if(nums[i]==nums[nums[i]-1])
//                {
//                    break;
//                }
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                 return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{0,1,2}));
    }
}