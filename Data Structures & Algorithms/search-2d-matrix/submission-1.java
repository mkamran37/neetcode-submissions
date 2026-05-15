class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        int row = 0;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target) {
                row = mid;
                break;
            }
            if (matrix[mid][0] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int[] find = matrix[row];
        start = 0;
        end = matrix[row].length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (find[mid] == target) {
                return true;
            }
            if (find[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
