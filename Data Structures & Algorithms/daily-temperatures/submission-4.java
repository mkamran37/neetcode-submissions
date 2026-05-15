class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        int curr = temperatures.length - 1;
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new int[]{temperatures[i], i});
            } else {
                while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                    result[stack.peek()[1]] = i - stack.pop()[1];
                }
                stack.push(new int[]{temperatures[i], i});
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()[1]] = 0;
        }
        return result;
    }
}
