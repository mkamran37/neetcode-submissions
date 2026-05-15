class Solution {
    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] < nums[end]) {
                result = Math.min(result, nums[start]);
                break;
            } 
            int m = start + ((end - start)/2);
            result = Math.min(result, nums[m]);
            if (nums[m] < nums[start]) {
                end = m - 1;
            } else if (nums[m] >= nums[start]) {
                start = m + 1;
            }
        }
        return result;
    }
}
