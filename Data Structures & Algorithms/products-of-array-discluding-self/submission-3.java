class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lsum = new int[nums.length];
        int[] rsum = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                lsum[i] = 1 * nums[i];
                continue;
            }
            lsum[i] = nums[i] * lsum[i - 1];
        }
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) {
                rsum[i] = 1 * nums[i];
                continue;
            }
            rsum[i] = rsum[i+1] * nums[i];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1 * rsum[i + 1];
                continue;
            }
            if(i == nums.length - 1) {
                result[i] = 1 * lsum[i-1];
                continue;
            }
            result[i] = rsum[i+1] * lsum[i - 1];
        }
        return result;
    }
}  
