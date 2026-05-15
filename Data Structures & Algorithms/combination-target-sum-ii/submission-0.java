class Solution {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayDeque<>(), 0);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, int target, int sum, Deque<Integer> tmp, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (start >= nums.length || sum > target) {
            return;
        }
        tmp.offerLast(nums[start]);
        backtrack(nums, target, sum + nums[start], tmp, start + 1);
        tmp.removeLast();
        backtrack(nums, target, sum, tmp, start + 1);
    }
}
