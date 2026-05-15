class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temps[i]) {
                result[stack.peek()[1]] = i - stack.pop()[1];
            }
            stack.push(new int[]{temps[i], i});
        }
        return result;
    }
}
