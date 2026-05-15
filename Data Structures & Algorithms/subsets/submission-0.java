class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> curr, int j) {
        if (nums.length == 0 || j >= nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[j]);
        backTrack(nums, result, curr, j+1);
        curr.remove(curr.size() - 1);
        backTrack(nums, result, curr, j+1);
    }
}
