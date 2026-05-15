class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, int target, Deque<Integer> dq, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(dq));
            return;
        }
        if (start == nums.length || target < 0) {
            return;
        }
            dq.addLast(nums[start]);
            backtrack(nums, target - nums[start], dq, start);
            dq.removeLast();
            backtrack(nums, target, dq, start + 1);
    }
}
