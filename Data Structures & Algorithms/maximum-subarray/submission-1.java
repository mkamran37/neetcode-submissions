class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = nums[0];
        for (int n: nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += n;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
