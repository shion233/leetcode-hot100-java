package 和为K的子数组560;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 用前缀和把任意子数组和转换成 prefix[j] - prefix[i]。
     * - 遍历到当前位置时，如果之前出现过 prefix - k，说明这些位置到当前都能组成和为 k 的子数组。
     * - HashMap 记录每个前缀和出现次数，边遍历边统计答案。
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        if(nums.length==0)
            return 0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            if(nums[i]==k){
                result++;
            }
            sum+=nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{0,0}, 0));
    }
}
