class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                return search(matrix[mid], target);
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
     public boolean search(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start)/2);
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }
        return false;
     }
}
