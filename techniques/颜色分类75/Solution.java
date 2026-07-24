package techniques.颜色分类75;

class Solution {
    /*
     * 做题思路：
     * - 题目要求把 0、1、2 原地排序，可以用荷兰国旗问题的三指针做一趟扫描。
     * - left 表示下一个 0 应该放的位置，right 表示下一个 2 应该放的位置，cur 表示当前正在判断的位置。
     * - 当 nums[cur] == 0 时，把它和 left 位置交换，说明左侧 0 的区域扩大，left 和 cur 都向右移动。
     * - 当 nums[cur] == 1 时，它本来就应该在中间区域，直接 cur++。
     * - 当 nums[cur] == 2 时，把它和 right 位置交换，说明右侧 2 的区域扩大；此时 cur 不动，因为换过来的元素还没有判断过。
     * - 注释掉的旧代码是我最初的解法：先统计 0、1、2 的数量，再分段重写数组，虽然正确但需要两次遍历；当前解法一趟扫描完成，更符合本题原地排序的常见技巧。
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int cur = 0;
        int right = nums.length - 1;

        while (cur <= right) {
            if (nums[cur] == 0) {
                swap(nums, cur, left);
                left++;
                cur++;
            } else if (nums[cur] == 1) {
                cur++;
            } else {
                swap(nums, cur, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
//    public void sortColors(int[] nums) {
//        int count0 = 0;
//        int count1 = 0;
//        int count2 = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                count0++;
//            }
//            if (nums[i] == 2) {
//                count2++;
//            }
//        }
//        count1 = nums.length - count0-count2;
//        for (int i = 0; i < count0; i++) {
//            nums[i] = 0;
//        }
//        for (int i = count0; i < count0+count1; i++) {
//            nums[i] = 1;
//        }
//        for (int i = count0+count1; i < nums.length; i++) {
//            nums[i] = 2;
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] t = {2, 0};
        solution.sortColors(t);
        for (int i = 0; i < t.length; i++) {
            System.out.print(t[i]+" ");
        }
    }
}
