class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[l] < nums[r]) {
                min = Math.min(min, nums[l]);
                break;
            } else {
                min = Math.min(min, nums[mid]);
                if (nums[l] <= nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return min; 
    }
}
