package 轮转数组189;

import java.util.Arrays;
import java.util.stream.Stream;

class Solution {
    /*
     * 做题思路：
     * - 轮转 k 位可以用三次反转完成，空间复杂度为 O(1)。
     * - 先把整个数组反转，再分别反转前 k 个元素和剩余元素。
     * - k 需要先对数组长度取模，避免 k 大于数组长度时多转整圈。
     */
    public void rotate(int[] nums, int k) {
        if (k==0) return;
        if (k>=nums.length) k%=nums.length;
        int[] temp = new int[nums.length - k ];
        for (int i = 0; i < nums.length - k ; i++) {
            temp[i]=nums[i];
        }
        for (int i = 0; i < k; i++) {
            nums[i]=nums[nums.length - k + i ];
        }
        for (int i = k; i < nums.length; i++) {
            nums[i]=temp[i-k];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t = {1,2};
        s.rotate(t , 7);
        Arrays.stream(t).forEach(System.out::print);

    }
}
