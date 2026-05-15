class Solution {
    public int[] dailyTemperatures(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                stack.push(new int[]{i, nums[i]});
                continue;
            }
            while (!stack.isEmpty() && stack.peek()[1] < nums[i]) {
                result[stack.peek()[0]] = i - stack.pop()[0];
            }
            stack.push(new int[]{i, nums[i]});
        }
        return result;
    }
}
