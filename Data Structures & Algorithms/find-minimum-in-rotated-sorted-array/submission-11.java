class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, result = Integer.MAX_VALUE;
        while (l <= r) {
            if (nums[l] <= nums[r]) {
                result = Math.min(result, nums[l]);
                return result;
            } else {
                int m = (l + r)/2;
                result = Math.min(result, nums[m]);
                if (nums[m] >= nums[l]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return result;
    }
}
