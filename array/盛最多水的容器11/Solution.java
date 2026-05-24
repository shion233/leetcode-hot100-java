package 盛最多水的容器11;

//双指针相向而行 + 只移动限制答案的一侧（短板）

class Solution {
    /*
     * 做题思路：
     * - 当前代码使用左右双指针，从最宽的容器开始尝试。
     * - 面积由较短的那条边决定，所以每次移动短板，才有机会遇到更高的边来弥补宽度减少。
     * - 注释掉的双重循环是我最初枚举所有组合的暴力思路；当前双指针把时间复杂度降为 O(n)。
     */
    public int maxArea(int[] height) {
        int max=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int temp=Math.min(height[left],height[right])*(right-left);
            if(temp>max){
                max=temp;
            }
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
//        for(int i=0;i<height.length;i++){

//            for(int j=i+1;j<height.length;j++){
//                int temp=Math.min(height[i],height[j])*(j-i);
//                if(temp>max){
//                    max=temp;
//                }
//            }
//        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
