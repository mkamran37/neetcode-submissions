class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                prefix[i] = nums[i - 1] * prefix[i - 1];
            }
        }
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            if (i == nums.length - 1) {
                suffix[j] = 1;
            } else {
                suffix[j] = nums[i+1] * suffix[j - 1];
            }
        }
        for (int i = 0, j = nums.length - 1; i <= nums.length - 1; i++, j--) {
            result[i] = prefix[i] * suffix[j];
        }
        return result;
    }
}  
