package binary_search.在排序数组中查找元素的第一个和最后一个位置34;

class Solution {
    /*
     * 做题思路：
     * - 题目要求在排序数组中找到 target 的第一个和最后一个位置，核心是把“找一个 target”改成“找左右边界”。
     * - searchRange 分别调用 findLeft 和 findRight：findLeft 在 nums[mid] >= target 时继续向左收缩，findRight 在 nums[mid] <= target 时继续向右收缩。
     * - ans 用来记录当前已经找到的 target 下标，即使继续缩小区间也不会丢失答案；如果一直没找到，就保持 -1。
     * - 注释掉的旧代码是我最初的解法：先二分找到任意一个 target，再从该位置向左右线性扫描扩展边界。
     * - 旧解法最坏情况下会退化到 O(n)，当前两次二分始终是 O(log n)，更符合题目要求。
     */
    public int[] searchRange(int[] nums, int target) {
        int left = findLeft(nums, target);
        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    // 找 target 的左边界
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    // 找 target 的右边界
    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
//    public int[] searchRange(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return new int[]{-1, -1};
//        int low = 0, high = nums.length - 1;
//        int temp = -1;
//        int[] res = new int[2];
//        while (low <= high) {
//            int mid = low + (high - low)/2;
//            if (nums[mid] == target) {
//                temp = mid;
//                break;
//            }
//            if (nums[mid] < target) {
//                low = mid + 1;
//            }
//            if (nums[mid] > target) {
//                high = mid - 1;
//            }
//        }
//        if (temp == -1) return new int[]{-1, -1};
//        for (int i = temp; i >=0 ; i--) {
//            if (nums[i] == target) {
//                res[0] = i;
//            }
//        }
//        for (int i = temp; i <nums.length ; i++) {
//            if (nums[i] == target) {
//                res[1] = i;
//            }
//        }
//        return res;
//    }
}
