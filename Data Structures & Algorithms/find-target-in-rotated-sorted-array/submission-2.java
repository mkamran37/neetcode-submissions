class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int m = start + (end - start)/2;
            if (nums[m] == target) return m;
            if (nums[start] <= nums[m]) {
                if (nums[m] < target || nums[start] > target) {
                    start = m + 1;
                } else {
                    end = m - 1;
                }
            } else {
                if (target < nums[m] || nums[end] < target) {
                    end = m - 1;
                } else {
                    start = m + 1;
                }
            }
        }
        return -1;
    }
}
