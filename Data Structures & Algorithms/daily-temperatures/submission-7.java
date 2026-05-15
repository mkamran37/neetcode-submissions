class Solution {
    public int[] dailyTemperatures(int[] tmps) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[tmps.length];
        for (int i = 0; i < tmps.length; i++) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && stack.peek()[1] < tmps[i]) {
                    int[] curr = stack.pop();
                    result[curr[0]] = i - curr[0];
                }
            }
            stack.push(new int[]{i, tmps[i]});
        }
        return result;
    }
}
