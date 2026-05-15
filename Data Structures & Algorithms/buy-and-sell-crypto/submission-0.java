class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] min = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            if (i == 0) {
                min[i] = prices[i];
            }
            else {
                min[i] = Math.min(min[i-1], prices[i]);
            }
        }
        for(int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(prices[i] - min[i], max);
        }
        return max;
    }
}
 