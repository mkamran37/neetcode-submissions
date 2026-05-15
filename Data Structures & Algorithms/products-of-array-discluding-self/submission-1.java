class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] result = new int[nums.length];

        for(int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            if (i == 0) {
                prefix[i] = 1;
            } else {
                prefix[i] = prefix[i-1] * nums[i - 1];
            }
            if ( j == nums.length - 1) {
                postfix[i] = 1;
            } else {
                postfix[i] = postfix[i - 1] * nums[j+1];
            }
        }
        for(int i = 0, j = nums.length - 1; i < nums.length && j >= 0; i++, j--) {
            result[i] = prefix[i] * postfix[j];
        }
        return result;
    }
}  
