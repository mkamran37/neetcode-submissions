class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return runBinary(matrix[mid], target);
            } else {
                if (matrix[mid][0] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }

    private boolean runBinary(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l)/2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
