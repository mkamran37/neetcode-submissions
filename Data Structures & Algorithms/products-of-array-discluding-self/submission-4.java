class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lsum = new int[nums.length];
        int start = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                lsum[i] = nums[i];
                continue;
            }
            lsum[i] = nums[i] * lsum[i - 1];
        }
        int[] rsum = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rsum[i] = nums[i];
                continue;
            }
            rsum[i] = nums[i] * rsum[i+1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = rsum[i+1];
            } else if( i == nums.length - 1) {
                result[i] = lsum[i - 1];
            } else {
                result[i] = lsum[i - 1] * rsum[i + 1];
            }
        }
        return result;
    }
}  
