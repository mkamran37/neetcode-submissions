class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, result = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (nums[start] < nums[end]) {
                result = Math.min(result, nums[start]);
                break;
            }
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            result = Math.min(result, nums[mid]);
        }
        return result;
    }
}
