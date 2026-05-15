class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayDeque<>());
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, int target, int start, Deque<Integer> dq) {
        if (target == 0) {
            result.add(new ArrayList<>(dq));
            return;
        }
        if (start >= nums.length || target < 0) {
            return;
        }
        dq.addLast(nums[start]);
        backtrack(nums, target - nums[start], start + 1, dq);
        dq.removeLast();
        backtrack(nums, target, start + 1, dq);
    }
}
