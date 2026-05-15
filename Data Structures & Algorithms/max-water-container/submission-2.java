class Solution {
    public int maxArea(int[] heights) {
        int result = Integer.MIN_VALUE;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int length = r - l, breadth = Math.min(heights[l], heights[r]);
            result = Math.max(result, length*breadth);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
