package array.最大子数组和53;

class Solution {
    /*
     * 做题思路：
     * - 当前代码是 Kadane 动态规划：currentMax 表示以当前位置结尾的最大子数组和。
     * - 对每个 nums[i]，要么接在前面的子数组后面，要么从当前元素重新开始。
     * - globalMax 记录遍历过程中出现过的最大值；注释掉的双重循环是我最初枚举所有子数组的暴力解法。
     */
    public int maxSubArray(int[] nums) {
                if (nums == null || nums.length == 0) return 0;

                int currentMax = nums[0];
                int globalMax = nums[0];

                for (int i = 1; i < nums.length; i++) {
                    // 要么延续前面的子数组，要么从当前元素重新开始
                    currentMax = Math.max(nums[i], currentMax + nums[i]);
                    // 更新全局最大值
                    globalMax = Math.max(globalMax, currentMax);
                }

                return globalMax;
//        int max=nums[0];
//        if(nums==null||nums.length==0)return 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum=nums[i];
//            if(sum>max){
//                max=sum;
//            }
//            for (int j = i+1; j < nums.length; j++) {
//                sum+=nums[j];
//                if(sum>max){
//                    max=sum;
//                }
//            }
//        }
//        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{1}));
    }
}
