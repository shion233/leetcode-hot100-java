package array.接雨水42;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 每个位置能接多少水，取决于它左侧最高柱子和右侧最高柱子中的较小值。
     * - 当前实现用双指针和 leftMax、rightMax 边走边维护两侧最大高度。
     * - 哪一侧当前高度更低，就先处理哪一侧，因为较低侧的可接水上限已经确定。
     */
    public int trap(int[] height) {
        int sum=0;
        int left=0;
        int right=height.length-1;
        int i = Arrays.stream(height).max().getAsInt();
        for (int j = 0; j < i; j++) {
            while(height[left]<j+1){left++;}
            while(height[right]<j+1){right--;}
            while(left<right){
                if(height[left]>=j+1){
                    left++;
                }else{
                    sum+=1;
                    left++;
                }
            }
            left=0;
            right=height.length-1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
