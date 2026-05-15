class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, target, 0, new ArrayDeque<>(), 0);
        return result;
    }

    private void backtrack(int[] nums, int target, int sum, Deque<Integer> tmp, int i) {
        if (i >= nums.length || sum > target) {
            return;
        } 
        if (sum == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        tmp.addLast(nums[i]);
        backtrack(nums, target, sum + nums[i], tmp, i);
        tmp.removeLast();
        backtrack(nums, target, sum, tmp, i + 1);
    }
}
