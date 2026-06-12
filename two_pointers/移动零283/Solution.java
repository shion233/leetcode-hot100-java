package two_pointers.移动零283;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 用 count 指向下一个非零元素应该放置的位置。
     * - 第一遍把所有非零元素按原相对顺序前移。
     * - 第二遍从 count 开始把剩余位置全部填 0，从而保持非零元素顺序不变。
     */
    public void moveZeroes(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[count++]=nums[i];
            }
        }
        for(int i=count;i<nums.length;i++){
            nums[i]=0;
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] r = {0, 1, 0, 3, 12};
        s.moveZeroes(r);
        Arrays.stream(r).forEach(System.out::print);
    }
}
