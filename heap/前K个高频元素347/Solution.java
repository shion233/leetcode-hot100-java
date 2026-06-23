package heap.前K个高频元素347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    /*
     * 做题思路：
     * - 题目要找出现频率最高的 k 个元素，先统计每个数字出现次数，再按频率取最大的 k 个。
     * - frequence 是哈希表，key 是 nums 中的数字，value 是该数字出现的次数。
     * - maxheap 是按频率排序的大顶堆，堆中每个 int[] 保存 {数字, 频率}，比较器让频率更高的元素排在堆顶。
     * - 先遍历 nums 完成计数，再把 frequence 中的每个 entry 放入 maxheap。
     * - 最后连续 poll k 次，每次取出的都是当前最高频元素，把它的数字部分放入 res。
     * - 代码没有注释掉的旧解法，当前思路是本题常见的“哈希表计数 + 堆取 Top K”解法，流程直观。
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 1 && nums.length==1) return nums;
        HashMap<Integer, Integer> frequence = new HashMap<>();
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a, b) -> Integer.compare(b[1] , a[1]));
        for (int i = 0; i < nums.length; i++) {
            frequence.put(nums[i], frequence.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequence.entrySet()) {
            maxheap.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxheap.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(res));
    }
}
