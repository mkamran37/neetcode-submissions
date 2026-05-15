class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
                continue;
            }
            prefix[i] = nums[i]*prefix[i - 1];
        }
        int[] suffix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffix[i] = nums[i];
                continue;
            }
            suffix[i] = nums[i] * suffix[i + 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = suffix[i + 1];
                continue;
            }
            if (i == nums.length - 1) {
                result[i] = prefix[i - 1];
                continue;
            } 
            result[i] = prefix[i - 1] * suffix[i+1];
        }
        return result;
    }
}  
