class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, result = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] < nums[r]) {
                result = Math.min(result, nums[l]);
                break;
            }
            result = Math.min(result, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }
}
