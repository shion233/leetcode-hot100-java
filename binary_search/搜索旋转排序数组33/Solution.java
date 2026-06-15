package binary_search.搜索旋转排序数组33;

class Solution {
    /*
     * 做题思路：
     * - 旋转排序数组虽然整体不是完全有序，但每次根据 mid 切分后，左半部分或右半部分至少有一边仍然有序。
     * - low 和 high 表示当前搜索区间，mid 是中点；如果 nums[mid] 等于 target，直接返回 mid。
     * - 当 nums[mid] >= nums[low] 时，说明 low 到 mid 这一段有序，再判断 target 是否落在 [nums[low], nums[mid]) 中，决定移动 high 还是 low。
     * - 否则说明 mid 到 high 这一段有序，再判断 target 是否落在 (nums[mid], nums[high]] 中，决定移动 low 还是 high。
     * - 代码没有注释掉的旧解法，当前思路就是本题常见的二分做法，时间复杂度为 O(log n)。
     */
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>=nums[low] ){
                if(target<nums[mid]&&target>=nums[low]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else if (nums[mid]<=nums[high]){
                if(target>nums[mid]&&target<=nums[high]){
                    low=mid+1;
                }else  {
                    high=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
