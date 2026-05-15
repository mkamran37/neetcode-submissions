class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] result = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (i == 0) {
                leftProduct[i] = nums[i];
                rightProduct[j] = nums[j];
                continue;
            }
            leftProduct[i] = leftProduct[i - 1] * nums[i];
            rightProduct[j] = rightProduct[j + 1] * nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            if(i == 0) {
                result[i] = rightProduct[i + 1];
            } else if (i == nums.length - 1) {
                result[i] = leftProduct[i - 1];
            } else {
                result[i] = rightProduct[i + 1] * leftProduct[i - 1];
            }
        }
        return result;
    }
}  
