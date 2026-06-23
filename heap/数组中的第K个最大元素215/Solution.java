package heap.数组中的第K个最大元素215;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    /*
     * 做题思路：
     * - 题目要找数组中第 k 个最大的元素，不需要完整排序，只要能不断取出当前最大值即可，所以使用堆。
     * - PriorityQueue 默认是小顶堆，这里通过 (a, b) -> Integer.compare(b, a) 改成大顶堆，让 heap.peek() 始终是当前最大值。
     * - 先把 nums 中所有元素加入 heap，此时堆顶是整个数组最大值。
     * - 通过 while (--k > 0) 连续 poll 掉前 k - 1 个更大的元素，剩下的 heap.peek() 就是第 k 大。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的堆解法，逻辑直观，适合先用堆理解第 k 大问题。
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)-> Integer.compare(b,a));
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        while (--k > 0)
            heap.poll();
        return heap.peek();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
