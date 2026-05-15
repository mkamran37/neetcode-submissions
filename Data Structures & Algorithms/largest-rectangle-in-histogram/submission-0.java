class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); //[index, height]
        int maxArea = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int h = stack.peek()[1];
                int ind = stack.pop()[0];
                maxArea = Math.max(maxArea, h * (i - ind));
                start = ind;
            }
            stack.push(new int[]{start, heights[i]});
        }
        while(!stack.isEmpty()) {
            int[] info = stack.pop();
            maxArea = Math.max(maxArea, info[1] * (length - info[0]));
        }
        return maxArea;
    }
}
