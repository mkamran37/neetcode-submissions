class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), 0, result, 0);
        return result;
    }

    private void backtrack(int[] nums, int target, List<Integer> curr, int sum, List<List<Integer>> result, int j) {
        if (sum == target) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (sum > target || j >= nums.length) {
            return;
        }
        curr.add(nums[j]);
        backtrack(nums, target, curr, sum+nums[j], result, j);
        curr.remove(curr.size() - 1);
        backtrack(nums, target, curr, sum, result, j+1);
    }
}
