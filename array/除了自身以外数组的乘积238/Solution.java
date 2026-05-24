package 除了自身以外数组的乘积238;

import java.util.Arrays;
//题目期望的解法是用前缀积和后缀积
class Solution {
    /*
     * 做题思路：
     * - 我当前实现先统计数组中 0 的个数，同时记录所有非零元素乘积。
     * - 没有 0 时，每个位置答案就是总乘积除以自己；只有一个 0 时，只有 0 所在位置能拿到非零乘积；
     *   多个 0 时所有位置都只能为 0。
     * - 这个思路容易想到，但使用了除法；题目更期望的优化方向是前缀积和后缀积，避免除法并保持 O(n)。
     */
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int sum = 1;
        int count = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=0 ) {
                sum *= nums[i];
            }
            else  {
                count++;
            }

        }
        if (count == 0) {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = sum / nums[i];
        }
        }
        else if (count == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    answer[i] = sum;
                }else  {
                    answer[i] = 0;
                }
            }
        }else {
            for (int i = 0; i < nums.length; i++) {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-1,1,0,-3,3};
        nums = s.productExceptSelf(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
