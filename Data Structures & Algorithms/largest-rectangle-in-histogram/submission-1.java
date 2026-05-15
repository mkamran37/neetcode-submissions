class Solution {
    public int largestRectangleArea(int[] h) {
        int result = 0;
        Stack<int[]> stack = new Stack<>(); //(index, height)
        for(int i = 0; i < h.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{i, h[i]});
                continue;
            }
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > h[i]) {
                int[] dims = stack.pop();
                result = Math.max(result, dims[1] * (i - dims[0]));
                start = dims[0];
            }
            stack.push(new int[]{start, h[i]});
        }
        int i = h.length;
        while(!stack.isEmpty()) {
            int[] dims = stack.pop();
            result = Math.max(result, dims[1] * (i - dims[0]));
        }
        return result;
    }
}
