class Solution {
    public int[] dailyTemperatures(int[] tmp) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < tmp[i]) {
                int[] t = stack.pop();
                result[t[1]] = i - t[1];
            }
            stack.push(new int[]{tmp[i], i});
        }
        return result;
    }
}
