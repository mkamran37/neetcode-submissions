class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int l = 0, r = 1;
        while (r < prices.length) {
            if (prices[l] < prices[r]) result = Math.max(result, prices[r] - prices[l]);
            else {
                l = r;
            }
            r++;
        }
        return result;
    }
}
