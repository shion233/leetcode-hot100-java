package techniques.多数元素169;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 题目保证多数元素出现次数超过数组长度的一半，可以用 Boyer-Moore 投票算法做抵消。
     * - result 表示当前候选的多数元素，count 表示当前候选元素相对其他元素的票数优势。
     * - 遍历 nums 时，如果 count == 0，说明之前的候选已经被抵消完，就把当前 nums[i] 作为新的候选 result。
     * - 如果 nums[i] 等于 result，就给候选元素加一票；否则用当前元素抵消一票。
     * - 因为真正的多数元素数量超过一半，和其他所有元素相互抵消后，最后留下的 result 一定是多数元素。
     * - 注释掉的旧代码是我最初的解法：排序后取中间位置，虽然正确但需要 O(n log n) 时间；当前投票算法只需 O(n) 时间和 O(1) 额外空间。
     */
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(count == 0){
                result = nums[i];
            }
            if (nums[i] == result) {
                count++;
            }else  {
                count--;
            }
        }
        return result;
    }
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
