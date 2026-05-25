package array.三数之和15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    /*
     * 做题思路：
     * - 当前代码先排序，再固定第一个数，用左右双指针寻找另外两个数。
     * - 和小于 0 时左指针右移，和大于 0 时右指针左移，等于 0 时记录答案并跳过重复值。
     * - 注释掉的三重循环是我最初的暴力解法，虽然直观，但复杂度高且需要额外去重；
     *   当前双指针解法利用排序后的单调性把复杂度降到 O(n^2)。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 记录答案
                    int leftVal = nums[left];
                    int rightVal = nums[right];

                    while (left < right && nums[left] == leftVal) left++;
                    while (left < right && nums[right] == rightVal) right--;
                }
            }
        }
        return lists;
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        list.sort(Integer::compareTo);
//                        if (!lists.contains(list)) {
//                            lists.add(list);
//                        }
//                    }
//                }
//            }
//        }
//        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
