package binary_search.寻找旋转排序数组中的最小值153;

class Solution {
    /*
     * 做题思路：
     * - 旋转排序数组可以看成两段递增数组拼在一起，最小值就是旋转点，所以可以用二分缩小旋转点所在区间。
     * - low 和 high 表示当前最小值可能出现的范围，mid 是中点；每次用 nums[mid] 和 nums[high] 比较判断哪一边仍然可能包含最小值。
     * - 如果 nums[mid] > nums[high]，说明 mid 落在左侧较大的一段，最小值一定在 mid 右边，所以 low = mid + 1。
     * - 如果 nums[mid] < nums[high]，说明 mid 到 high 这一段有序，最小值可能就是 mid，也可能在左边，所以 high = mid。
     * - 代码没有注释掉的旧解法，当前思路是本题常见二分做法，最终 low == high 时该位置就是最小值下标。
     * - 本题旋转感觉更像是循环右移
     */
    public int findMin(int[] nums) {
        if (nums.length==1) return nums[0];
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if (nums[mid]>nums[high]){
                low=mid+1;
            }
            else if (nums[mid]<nums[high]){
                high=mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{5,1,2,3,4}));
    }
}
