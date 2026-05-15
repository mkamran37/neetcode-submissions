class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, result = 0;
        while (r < prices.length) {
            while (r < prices.length && prices[l] < prices[r]) {
                result = Math.max(result, prices[r] - prices[l]);
                r++;
            }
            l = r;
            r = l + 1;
        }
        return result;
    }
}
