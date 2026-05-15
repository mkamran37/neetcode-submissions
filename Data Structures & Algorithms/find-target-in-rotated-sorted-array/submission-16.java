class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int pivot = l;
        int result = binSearch(nums, 0, pivot - 1, target);
        if (result < 0) {
            result = binSearch(nums, pivot, nums.length - 1, target);
        }
        return result;
    }

    private int binSearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int m = (start + end)/2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                start = m + 1;
            } else {
                end = m - 1;
            }
        }
        return -1;
    }
}
