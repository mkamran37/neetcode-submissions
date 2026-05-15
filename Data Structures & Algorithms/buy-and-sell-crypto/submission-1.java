class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            max = Math.max(prices[i] - minPrice, max);
        }
        return max;
    }
}
 