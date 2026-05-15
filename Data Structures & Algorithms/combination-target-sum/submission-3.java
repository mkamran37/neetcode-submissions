class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayDeque<>());
        return result;
    }

    private void backtrack(int[] nums, int target, int start, Deque<Integer> dq) {
        if (target == 0) {
            result.add(new ArrayList<>(dq));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            dq.addLast(nums[i]);
            backtrack(nums, target - nums[i], i, dq);
            dq.removeLast();
        }

    }
}
