package greedy.买卖股票的最佳时机121;

class Solution {
    /*
     * 做题思路：
     * - 只能先买后卖，所以遍历到第 i 天时，最优买入价一定来自 i 之前出现过的最低价格。
     * - min 记录当前遍历过程中见过的最低股票价格，表示如果今天卖出，之前最便宜的买入成本。
     * - max 记录当前能获得的最大利润，每天用 prices[i] - min 尝试更新最大收益。
     * - 如果 prices[i] 比 min 更低，就更新 min，表示以后可以用更低价格买入。
     * - 代码没有注释掉的旧解法，当前思路是本题常见贪心做法，只需一次遍历即可得到最大利润。
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
