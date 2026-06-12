package binary_search.搜索插入位置35;

class Solution {
    /*
     * 做题思路：
     * - nums 已经按升序排列，要找 target 的位置，或者它应该插入的位置，适合用二分查找。
     * - l 和 r 分别表示当前还可能包含答案的左右边界，每次取 mid 判断 nums[mid] 和 target 的关系。
     * - 如果 nums[mid] == target，说明已经找到目标下标，直接返回 mid。
     * - 如果 nums[mid] > target，target 只可能在左半部分，移动 r；如果 nums[mid] < target，就移动 l 到右半部分。
     * - 循环结束后 l == r，再根据 nums[l] 是否大于等于 target，决定插入位置是 l 还是 l + 1。
     */
    public int searchInsert(int[] nums, int target) {
        if(nums==null||nums.length==0) return 0;
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else if(nums[mid]<target){
                l=mid+1;
            }
        }
        return nums[l]>=target?l:l+1;
    }
}
