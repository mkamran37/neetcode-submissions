class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];
        for(int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (i == 0 && j == nums.length - 1) {
                prefix[i] = nums[i];
                suffix[j] = nums[j];
                continue;
            }

                prefix[i] = nums[i] * prefix[i - 1];
                suffix[j] = nums[j] * suffix[j + 1];
            
        }
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = suffix[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = prefix[i - 1];
            } else {
                result[i] = prefix[i - 1] * suffix[i + 1];
            }
        }
        return result;
    }
}  
