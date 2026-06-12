package substring.滑动窗口最大值239;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

class Solution {
    /*
     * 做题思路：
     * - 窗口最大值需要快速拿到当前窗口最大元素，所以用单调队列维护候选下标。
     * - 队列从头到尾对应的值保持递减，队头始终是当前窗口最大值下标。
     * - 每次右侧新元素进入时，弹出队尾所有比它小的元素；左侧滑出窗口时，队头过期就弹出。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length-k+1];
//        for (int i = 0; i < nums.length-k+1; i++) {
//            int max =0;
//            max=nums[i];
//            for (int j = i+1; j < i+k; j++) {
//                if(nums[j]>max)
//                    max=nums[j];
//            }
//            result[i]=max;
//        }
        int[] result = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>(); // 存下标，保证对应值单调递减

        for (int i = 0; i < nums.length; i++) {
            // 规则1：新来的大，把队尾所有“打不过”它的全踢掉
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            // 规则2：自己入队
            deque.offerLast(i);

            // 规则3：队首如果已经滑出窗口（下标 <= i-k），扔掉
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 窗口一旦形成（从第 k-1 个元素开始），队首就是最大值
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
//        int index = 0;
//        Queue<Integer> queue = new LinkedBlockingQueue<>();
//        for (int i = 0; i < k; i++) {
//            queue.add(nums[i]);
//        }
//        Integer i = queue.stream().max(Integer::compareTo).get();
//        result[index++]=i;
//        for (int j = k; j < nums.length; j++) {
//            queue.poll();
//            queue.add(nums[j]);
//            i = queue.stream().max(Integer::compareTo).get();
//            result[index++]=i;
//        }
    }

    public static void main(String[] args) {
        int[] ints = new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
