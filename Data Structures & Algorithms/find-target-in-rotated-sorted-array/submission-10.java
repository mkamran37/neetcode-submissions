class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r)/2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int pivot = l;
        int result = binSearch(nums, 0, pivot - 1, target);
        if (result < 0) {
            result = binSearch(nums, pivot, nums.length - 1, target);
        }
        return result;
    }

    private int binSearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
