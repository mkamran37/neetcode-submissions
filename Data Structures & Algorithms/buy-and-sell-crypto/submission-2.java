class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            result = Math.max(result, prices[i]-min);
        }
        return result;
    }
}
