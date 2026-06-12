package two_pointers.接雨水42;

import java.util.Arrays;

class Solution {
    /*
     * 做题思路：
     * - 解法1按水位一层一层扫描：先找到最高柱子的高度，再从第 1 层到最高层统计每一层能装多少水。
     * - 对每一层，left 和 right 先收缩到这一层左右两边的有效挡板，中间高度不够当前水位的位置就可以接 1 格水。
     * - 做法2是双指针写法：leftMax 和 rightMax 分别维护左右两侧最高柱子，较低的一侧决定当前位置能接多少水。
     * - 两种写法都围绕“水位受较矮挡板限制”这个规律；做法2一次遍历即可完成，时间复杂度更优。
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
//    做法2:双指针写法
    public int trap2(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
