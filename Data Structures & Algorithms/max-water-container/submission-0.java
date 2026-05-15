class Solution {
    public int maxArea(int[] heights) {
        int result = Integer.MIN_VALUE;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            result = Math.max(result, width * height);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
