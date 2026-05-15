class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row: matrix) {
            if (searchRow(row, target)) {
                return findElem(row, target);
            }
        }
        return false;
    }

    public boolean searchRow(int[] row, int target) {
        if (row[0] <= target && row[row.length - 1] >= target) return true;
        return false;
    }

    private boolean findElem(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (row[mid] == target) return true;
            else if (row[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
