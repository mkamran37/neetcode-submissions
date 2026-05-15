class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, max = 0;
        while (l < r) {
            int length = r - l, breadth = Math.min(heights[l], heights[r]);
            max = Math.max(max, length*breadth);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
