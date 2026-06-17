package binary_search.寻找两个正序数组的中位数4;

class Solution {
    /*
     * 做题思路：
     * - 两个数组本身都是正序，求中位数可以转化为求合并后数组中的第 k 小元素，但不需要真的合并数组。
     * - findMedianSortedArrays 根据总长度 len 判断奇偶：奇数时找第 len / 2 + 1 小，偶数时分别找第 len / 2 和 len / 2 + 1 小再取平均。
     * - findKth 中 i、j 分别表示 nums1 和 nums2 当前还没被排除的起点，k 表示还要在剩余元素里找第 k 小。
     * - 每轮取 step = k / 2，比较 nums1[p1] 和 nums2[p2]，较小的一边前 count 个元素不可能是第 k 小，可以整体丢弃并更新 i 或 j。
     * - 边界上，如果某个数组已经用完，就直接从另一个数组取；如果 k == 1，就返回两个当前起点中的较小值。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的二分缩小第 k 小范围的做法，避免 O(m + n) 合并。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;

        if (len % 2 == 1) {
            return findKth(nums1, nums2, len / 2 + 1);
        } else {
            int left = findKth(nums1, nums2, len / 2);
            int right = findKth(nums1, nums2, len / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    private int findKth(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;

        while (true) {
            if (i == m) {
                return nums2[j + k - 1];
            }

            if (j == n) {
                return nums1[i + k - 1];
            }

            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }

            int step = k / 2;

            int p1 = Math.min(i + step, m) - 1;
            int p2 = Math.min(j + step, n) - 1;

            if (nums1[p1] <= nums2[p2]) {
                int count = p1 - i + 1;
                i = p1 + 1;
                k -= count;
            } else {
                int count = p2 - j + 1;
                j = p2 + 1;
                k -= count;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{1,2,3,4}, new int[]{5}));
    }
}
