class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] postfixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixSum[i] = nums[i];
                continue;
            }
            prefixSum[i] = nums[i] * prefixSum[i-1];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfixSum[i] = nums[i];
                continue;
            }
            postfixSum[i] = nums[i] * postfixSum[i+1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = postfixSum[i + 1];
                continue;
            }
            if (i == nums.length - 1) {
                result[i] = prefixSum[i - 1];
                continue;
            }
            result[i] = prefixSum[i - 1] * postfixSum[i + 1];
        }
        return result;
    }
}  
